package br.com.compasso.springbootinterview.api.infrastruture.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.springbootinterview.api.aplication.service.CidadeService;
import br.com.compasso.springbootinterview.api.domain.cidade.Cidade;
import br.com.compasso.springbootinterview.api.enums.Estado;
import br.com.compasso.springbootinterview.api.exceptionhandler.Erro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@ApiOperation(value = "Busca todas as Cidades.", notes = "Método que busca todas as cidades")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Busca executada com sucesso") })
	@GetMapping
	public List<Cidade> listAll() {
		return cidadeService.listAll();
	}

	@ApiOperation(value = "Busca uma cidade através do id.", response = Cidade.class, notes = "Método que busca uma cidade através do id.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Busca executada com sucesso", response = Cidade.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok(cidade);
	}

	@ApiOperation(value = "Busca uma cidade através do nome.", response = Cidade.class, notes = "Método que busca uma cidade através do nome.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Busca executada com sucesso", response = Cidade.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Cidade> findByName(@PathVariable String nome) {
		Cidade cidade = cidadeService.findByName(nome);
		return ResponseEntity.ok(cidade);
	}

	@ApiOperation(value = "Busca uma cidade através do estado.", response = Cidade.class, notes = "Método que busca uma cidade através do estado.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Busca executada com sucesso", response = Cidade.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado", response = Erro.class) })
	@GetMapping("/estado/{estado}")
	public ResponseEntity<Cidade> findByEstado(@PathVariable String estado) {
		Cidade cidade = cidadeService.findByEstado(Estado.valueOf(Estado.class, estado));
		return ResponseEntity.ok(cidade);
	}

	@ApiOperation(value = "Cadastar cidade.", response = Cidade.class, notes = "Método que cadastra uma cidade.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cadastro executado com sucesso", response = Cidade.class) })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade create(@Valid @RequestBody Cidade cidade) {
		return cidadeService.create(cidade);
	}

}
