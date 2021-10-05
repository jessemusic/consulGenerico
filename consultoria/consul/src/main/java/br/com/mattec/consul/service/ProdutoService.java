package br.com.mattec.consul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.entities.ProdutoEntity;
import br.com.mattec.consul.reporitory.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public List<ProdutoEntity> findAll(){
		return repo.findAll();
	}
	
	public Optional<ProdutoEntity> find(Long id){
		return repo.findById(id);
	}
	
	
	public ProdutoEntity insert(ProdutoEntity categoria) {
		return repo.save(categoria);
	}
	
	
	



}