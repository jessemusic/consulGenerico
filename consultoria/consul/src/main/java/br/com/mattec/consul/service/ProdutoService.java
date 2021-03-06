package br.com.mattec.consul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.ProdutoCadastraDto;
import br.com.mattec.consul.dto.ProdutoDto;
import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.entities.ProdutoEntity;
import br.com.mattec.consul.reporitory.CategoriaRepository;
import br.com.mattec.consul.reporitory.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repoProduto;
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	
	
	public List<ProdutoDto> findAll(){
		List<ProdutoEntity> produtoEntities = this.repoProduto.findAll();
		
		List<ProdutoDto> listProduto = new ArrayList<>();
		
		produtoEntities.forEach(pro -> {
			ProdutoDto produtoDto = ProdutoDto.builder().build();
			produtoDto.setId(pro.getId());
			produtoDto.setNome(pro.getNome());
			produtoDto.setPreco(pro.getPreco());
			produtoDto.setCodigoDeBarra(pro.getCodigoDeBarra());
			produtoDto.setQuantidade(pro.getQuantidade());
			produtoDto.setCategoria(pro.getCategorias().getNomeDaCategoria());
			
			listProduto.add(produtoDto);
		});
			
		return listProduto;
	}
	
	
	public void insert(ProdutoCadastraDto cadDto) {
		Optional<Categoria> pegaId =repoCategoria.findById(cadDto.getIdCategoria());
		ProdutoEntity produto = ProdutoEntity.builder()
				.nome(cadDto.getNome())
				.preco(cadDto.getPreco())
				.quantidade(cadDto.getQuantidade())
				.codigoDeBarra(geraCodigoDeBarras().getCodigoDeBarra() +1)
				.build();
		
		if(pegaId.isPresent()) {
			produto.setCategorias(pegaId.get());
			this.repoProduto.save(produto);
		}
		
	}
	
	public Object findAllAndCategoria() {
		return null;
	}
	
	private ProdutoEntity geraCodigoDeBarras() {
	List<ProdutoEntity> codigoDeBarra = findCodigoDeBarra();
		return codigoDeBarra.get(0);
	}


	public List<ProdutoEntity> findCodigoDeBarra() {
		List<ProdutoEntity> list = repoProduto.findAllByOrderByCodigoDeBarraDesc(); 
		return list;
	}
}