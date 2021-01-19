package br.com.compasso.springbootinterview.api.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByNome(String nome);
}
