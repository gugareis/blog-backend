package com.frwk.blog.controller;



import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frwk.blog.dto.AuthRequestDto;
import com.frwk.blog.dto.AuthResponseDto;
import com.frwk.blog.dto.NewAccountDto;
import com.frwk.blog.entity.User;
import com.frwk.blog.service.CustomUserDetailsService;
import com.frwk.blog.service.UserService;
import com.frwk.blog.util.JwtUtil;

/**
 * Classe controle de acesso Rest de dados dos usuários.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/*")
public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
//	
		
	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> authLogin(@RequestBody AuthRequestDto login) throws Exception{
		//modelo pde validação para senha criptografada
		String senha = login.getPassword();
		login.setPassword(DigestUtils.sha256Hex(senha));
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Nome ou senha incorreta");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponseDto(jwt));
	}
	@RequestMapping(value = "/api/newaccount", method = RequestMethod.POST)
	public ResponseEntity<?> newAccount(@RequestBody NewAccountDto account) throws Exception{
		//modelo pde validação para senha criptografada
		String senha = account.getPassword();
		account.setPassword(DigestUtils.sha256Hex(senha));
		
		return ResponseEntity.ok(userService.registerUser(account));
	}
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public ResponseEntity<?> getList(Authentication authentication) {
		final User user = userService.getUserByUserName(authentication.getName());
		return ResponseEntity.ok(user);
	}
	
}
