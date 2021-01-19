package br.com.compasso.springbootinterview.api.infrastruture.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.springbootinterview.api.aplication.service.ClienteService;
import br.com.compasso.springbootinterview.api.domain.cliente.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> ListAll() {
		return clienteService.ListAll();
	}
	
	@GetMapping("/{id}")
	public Cliente findById(long id) {
		return clienteService.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Cliente findByNome(String nome) {
		return clienteService.findByNome(nome);
	}

}
