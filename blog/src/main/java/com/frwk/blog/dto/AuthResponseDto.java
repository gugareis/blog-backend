package com.frwk.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de transferencia de objetos de Login.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
	private	String jwt;
}
