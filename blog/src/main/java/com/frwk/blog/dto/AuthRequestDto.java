package com.frwk.blog.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class AuthRequestDto {
	private	String userName;
	private	String password;
}
