package br.com.mattec.consul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.dto.ProdutoDto;
import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.entities.ClientEntity;
import br.com.mattec.consul.entities.EnderecoEntity;
import br.com.mattec.consul.entities.ProdutoEntity;
import br.com.mattec.consul.exceptions.ValidaException;
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
			produtoDto.setDataDeCompra(pro.getDataDeCompra());
			produtoDto.setDataDeValidade(pro.getDataDeValidade());
			produtoDto.setNomeCategoria(pro.getCategorias().getNomeDaCategoria());
			
			listProduto.add(produtoDto);
		});
		
		
		return listProduto;
	}
	
	
	public void insert(ProdutoDto cadDto) {
		ProdutoEntity produto = ProdutoEntity.builder().nome(cadDto.getNome()).preco(cadDto.getPreco())
				.codigoDeBarra(cadDto.getCodigoDeBarra())
				.dataDeCompra(cadDto.getDataDeCompra()).dataDeValidade(cadDto.getDataDeValidade())
				.build();
		Categoria categoria = Categoria.builder().id(cadDto.getId()).build();
		produto.setCategorias(categoria);
		this.repoProduto.save(produto);
		this.repoCategoria.save(categoria);
		
	}
	
	public Object findAllAndCategoria() {
		return null;
	}
	
	
	



}