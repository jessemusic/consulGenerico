package br.com.mattec.consul.reporitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mattec.consul.entities.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    
	Optional<EnderecoEntity> findByCep(String cep);

}
