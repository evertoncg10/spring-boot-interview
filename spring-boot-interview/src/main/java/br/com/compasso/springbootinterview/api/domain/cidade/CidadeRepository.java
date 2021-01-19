package br.com.compasso.springbootinterview.api.domain.cidade;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.springbootinterview.api.enums.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public Cidade findByNome(String nome);

	public Cidade findByEstado(Estado estado);

}
