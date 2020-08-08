package com.frwk.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountDto {
	private	String userName;
	private	String name;
	private	String email;
	private	String password;
}
