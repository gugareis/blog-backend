package com.frwk.blog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.frwk.blog.entity.User;
import com.frwk.blog.repository.UserRepository;
/**
 * Classe de serviços de authenticação dos Usuários.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	/**
	   * Método que busca o usuário para autenticação.
	   * @param userName campo de login do usuário na base de dados.
	   * @return validação dos dados para controle de acesso no frontend.
	   */	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>()); 
	}
}
