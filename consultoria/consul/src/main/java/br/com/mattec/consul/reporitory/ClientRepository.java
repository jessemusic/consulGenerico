package br.com.mattec.consul.reporitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome, c.cpf, c.numeroEndereco, "
			+ "e.cep, e.logradouro, e.complemento, e.bairro, "
			+ "e.localidade, e.uf) FROM Client c "
			+ "INNER JOIN Endereco e ON c.endereco.id = e.id")
	List<CadastraDto> findAllCadastro();
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome, c.cpf, c.numeroEndereco, "
			+ "e.cep, e.logradouro, e.complemento, e.bairro, "
			+ "e.localidade, e.uf) FROM Client c "
			+ "INNER JOIN Endereco e ON c.endereco.id = e.id where e.logradouro = :rua ")
	List<CadastraDto> findAllClientEnderecoOne(@Param("rua") String rua);
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome, c.cpf, c.numeroEndereco, "
			+ "es.cep, es.logradouro, es.complemento, es.bairro, "
			+ "es.localidade, es.uf) FROM Client c "
			+ "INNER JOIN Endereco es ON c.endereco.id = es.id where c.cpf = :cpf ")
	Optional<CadastraDto> findbyCpfOne(@Param("cpf") String cpf);

	Optional<Client> findByCpf(String cpf);
}
