package br.com.compasso.springbootinterview.api.domain.cidade.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}
}
