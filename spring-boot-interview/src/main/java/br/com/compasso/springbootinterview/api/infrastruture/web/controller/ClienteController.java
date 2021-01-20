package br.com.compasso.springbootinterview.api.infrastruture.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import br.com.compasso.springbootinterview.api.exceptionhandler.Erro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Busca todos os Clientes.", 
				  notes = "Método que busca todos os clientes.")
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					     message = "Busca executada com sucesso") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> ListAll() {
		return clienteService.ListAll();
	}

	@ApiOperation(value = "Busca um cliente através do id.", response = Cliente.class, notes = "Método que busca um cliente através do id.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Busca executada com sucesso", response = Cliente.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente findById(long id) {
		return clienteService.findById(id);
	}

	@ApiOperation(value = "Busca um cliente através do nome.", response = Cliente.class, notes = "Método que busca um cliente através do nome.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Busca executada com sucesso", response = Cliente.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@GetMapping(value = "/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente findByNome(String nome) {
		return clienteService.findByNome(nome);
	}

	@ApiOperation(value = "Cadastar Cliente.", response = Cliente.class, notes = "Método que cadastra um cliente.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cadastro executado com sucesso", response = Cliente.class) })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@Valid @RequestBody Cliente cliente) {
		return clienteService.create(cliente);
	}

	@ApiOperation(value = "Deletar Cliente.", response = Cliente.class, notes = "Método que deleta um cliente.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Cliente deletado com sucesso") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualizar o nome do cliente.", response = Cliente.class, notes = "Método que atualiza o nome do cliente.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso", response = Cliente.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@PutMapping(value = "/nome/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> updateByName(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.updateByName(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);

	}

	@ApiOperation(value = "Atualizar o cliente.", response = Cliente.class, notes = "Método que atualiza o cliente através do id.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso", response = Cliente.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> update(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);

	}
}
