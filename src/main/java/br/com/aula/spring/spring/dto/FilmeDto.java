package br.com.aula.spring.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmeDto(	@NotBlank String titulo, 
						@NotNull Integer ano, 
						@NotNull Double duracao, 
						@NotBlank String genero ) {
}