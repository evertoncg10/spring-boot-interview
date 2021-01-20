package br.com.compasso.springbootinterview.api.infrastruture.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@Valid @RequestBody Cliente cliente) {
		return clienteService.create(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/nome/{id}")
	public ResponseEntity<Cliente> updateByName(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.updateByName(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);

	}
}
