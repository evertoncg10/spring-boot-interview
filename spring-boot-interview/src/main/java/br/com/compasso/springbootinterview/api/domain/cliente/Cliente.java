package br.com.compasso.springbootinterview.api.domain.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.compasso.springbootinterview.api.domain.cidade.Cidade;
import br.com.compasso.springbootinterview.api.enums.Sexo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Nome não pode ser vazio")
	@NotNull(message = "O Nome é obrigatório")
	@Size(max = 120)
	private String nome;

	@NotNull(message = "Sexo é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Sexo sexo;

	@NotNull(message = "Data de nascimento é obrigatório")
	private LocalDate dataNascimento;

	@Positive
	private int idade;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

}
