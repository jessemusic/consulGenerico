package br.com.mattec.consul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.reporitory.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cateRepo;
	
	public List<Categoria> findAll(){
		return cateRepo.findAll();
	}
	
	public Optional<Categoria> find(Long id){
		return cateRepo.findById(id);
	}
	
	
	public Categoria insert(Categoria categoria) {
		return cateRepo.save(categoria);
	}
	
	
	



}