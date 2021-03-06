package br.com.mattec.consul.reporitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome, c.tipo, c.cpfOuCnpj, c.numeroEndereco, "
			+ "e.cep, e.logradouro, e.complemento, e.bairro, "
			+ "e.localidade, e.uf) FROM ClientEntity c "
			+ "INNER JOIN EnderecoEntity e ON c.endereco.id = e.id")
	List<CadastraDto> findAllCadastro();
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome, c.tipo,c.cpfOuCnpj, c.numeroEndereco, "
			+ "e.cep, e.logradouro, e.complemento, e.bairro, "
			+ "e.localidade, e.uf) FROM ClientEntity c "
			+ "INNER JOIN EnderecoEntity e ON c.endereco.id = e.id where e.logradouro = :rua ")
	List<CadastraDto> findClientsEnderecoOne(@Param("rua") String rua);
	
	@Query("SELECT new br.com.mattec.consul.dto.CadastraDto(c.nome,c.tipo, c.cpfOuCnpj,c.numeroEndereco, "
			+ "es.cep, es.logradouro, es.complemento, es.bairro, "
			+ "es.localidade, es.uf) FROM ClientEntity c "
			+ "INNER JOIN EnderecoEntity es ON c.endereco.id = es.id where c.cpfOuCnpj = :cpfOuCnpj ")
	Optional<CadastraDto> findOneWithCpfOuCnpj(@Param("cpfOuCnpj") String cpfOuCnpj);

	Optional<ClientEntity> findByCpfOuCnpj(String cpfOuCnpj);
}
