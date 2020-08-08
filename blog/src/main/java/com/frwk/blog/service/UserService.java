package com.frwk.blog.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.frwk.blog.dto.NewAccountDto;
import com.frwk.blog.entity.User;
import com.frwk.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
/**
 * Classe de serviços dos dados dos Usuários.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  /**
   * Método que cria o usuário.
   * @param name campo com nome completo do usuário na base de dados.
   * @param email campo de e-mail do usuário na base de dados.
   * @param userName campo de login do usuário na base de dados.
   * @param senha campo de password  do usuário na base de dados.
   * @return usuário criado.
   */	
  public User registerUser(NewAccountDto newUser) {
	User user = new User();
	user.setUserName(newUser.getUserName());
	user.setName(newUser.getName());
	user.setPassword(newUser.getPassword());
	user.setEmail(newUser.getEmail());
    user.setCreate_date(LocalDateTime.now());
    return userRepository.save(user);
  }
  public User getUserByUserName(String userName) {
	  return userRepository.findByUserName(userName);
  }

}
