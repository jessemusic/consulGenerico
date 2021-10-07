package br.com.mattec.consul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.ProdutoDto;
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
			produtoDto.setDataDeCompra(pro.getDataDeCompra());
			produtoDto.setDataDeValidade(pro.getDataDeValidade());
			produtoDto.setNomeCategoria(pro.getCategorias().getNomeDaCategoria());
			
			listProduto.add(produtoDto);
		});
		
		
		return listProduto;
	}
	
//	public Optional<List<ProdutoDto>> findlist(ProdutoDto dto){
//		
//		ProdutoEntity produto = ProdutoEntity.builder().id(dto.getId())
//				.nome(dto.getNome())
//				.preco(dto.getPreco())
//				.codigoDeBarra(dto.getCodigoDeBarra())
//				.dataDeCompra(dto.getDataDeCompra())
//				.dataDeValidade(dto.getDataDeValidade()).build();
//				
//		Categoria category = Categoria.builder().nomeDaCategoria(dto.getNomeCategoria().toString()).build();
//		produto.setCategorias(category);
//		this.repoCategoria.getById(category.getId());
//		this.repoProduto.getById()
//			
//
//		return repoProduto.findAllById(produto);
//	}
	
	
	public ProdutoEntity insert(ProdutoEntity categoria) {
		return repoProduto.save(categoria);
	}


	
	public Object findAllAndCategoria() {
		return null;
	}
	
	
	



}