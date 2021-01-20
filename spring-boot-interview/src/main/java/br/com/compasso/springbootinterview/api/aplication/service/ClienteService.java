package br.com.compasso.springbootinterview.api.aplication.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.compasso.springbootinterview.api.domain.cliente.Cliente;
import br.com.compasso.springbootinterview.api.domain.cliente.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> ListAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		Cliente cliente = optionalCliente.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cliente;
	}

	public Cliente findByNome(String nome) {
		Optional<Cliente> optionalCliente = Optional.ofNullable(clienteRepository.findByNome(nome));
		Cliente cliente = optionalCliente.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cliente;
	}

	public Cliente create(@Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return clienteRepository.existsById(id);
	}

}
