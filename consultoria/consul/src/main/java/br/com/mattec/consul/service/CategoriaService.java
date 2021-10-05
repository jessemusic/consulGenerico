package br.com.mattec.consul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.reporitory.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cateRepo;
	
	public Categoria insert(Categoria categoria) {
		return cateRepo.save(categoria);
	}
	
	public List<Categoria> findAll(){
		return cateRepo.findAll();
	}
	



}