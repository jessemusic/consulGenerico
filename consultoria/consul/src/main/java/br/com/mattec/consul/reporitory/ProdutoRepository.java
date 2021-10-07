package br.com.mattec.consul.reporitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mattec.consul.dto.ProdutoDto;
import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	
//	@Query("SELECT new br.com.mattec.consul.dto.ProdutoDto(p.nome, p.preco, p.codigoDeBarra, p.dataDeCompra,p.dataDeValidade "
//			+ "ct.nomeCategoria) FROM ProdutoEntity p "
//			+ "INNER JOIN Categoria ct ON p.categoria.id = ct.nome")
//	Optional<List<ProdutoDto>> findAllById(ProdutoEntity produto);
}