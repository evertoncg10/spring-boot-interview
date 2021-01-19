package br.com.compasso.springbootinterview.api.infrastruture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.springbootinterview.api.aplication.service.CidadeService;
import br.com.compasso.springbootinterview.api.domain.cidade.Cidade;
import br.com.compasso.springbootinterview.api.enums.Estado;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public List<Cidade> listAll() {
		return cidadeService.listAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok(cidade);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Cidade> findByName(@PathVariable String nome) {
		Cidade cidade = cidadeService.findByName(nome);
		return ResponseEntity.ok(cidade);
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<Cidade> findByEstado(@PathVariable String estado) {
		Cidade cidade = cidadeService.findByEstado(Estado.valueOf(Estado.class, estado));
		return ResponseEntity.ok(cidade);
	}

}
