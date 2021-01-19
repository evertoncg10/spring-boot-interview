package br.com.compasso.springbootinterview.api.aplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.compasso.springbootinterview.api.domain.cidade.Cidade;
import br.com.compasso.springbootinterview.api.domain.cidade.CidadeRepository;
import br.com.compasso.springbootinterview.api.enums.Estado;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> listAll() {
		List<Cidade> findAll = cidadeRepository.findAll();
		return findAll;
	}

	public Cidade findById(Long id) {
		Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
		Cidade cidade = optionalCidade.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cidade;
	}

	public Cidade findByName(String nome) {
		Optional<Cidade> optionalCidade = null;
		optionalCidade = Optional.ofNullable(cidadeRepository.findByNome(nome));
		Cidade cidade = optionalCidade.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cidade;
	}

	public Cidade findByEstado(Estado estado) {
		Optional<Cidade> optionalCidade = null;
		optionalCidade = Optional.ofNullable(cidadeRepository.findByEstado(estado));
		Cidade cidade = optionalCidade.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cidade;
	}
}
