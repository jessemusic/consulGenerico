package br.com.mattec.consul.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mattec.consul.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	

	List<ProdutoEntity> findAllByOrderByCodigoDeBarraDesc();
}