package com.frwk.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frwk.blog.dto.CommentsDto;
import com.frwk.blog.entity.Comments;
import com.frwk.blog.entity.User;
import com.frwk.blog.service.CommentsService;
import com.frwk.blog.service.UserService;
/**
 * Classe controle de acesso Rest de dados dos comments.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@RestController
@CrossOrigin(origins = "*")
public class CommentsController {
	@Autowired
	private UserService userService;
	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
	public ResponseEntity<?> addComent(@RequestBody CommentsDto commentsDto,Authentication authentication) {
		final User user = userService.getUserByUserName(authentication.getName());
		commentsService.addComent(commentsDto, user);

		return ResponseEntity.ok("Arquivo gravado com sucesso!");
	}

	@RequestMapping(value = "/comment/list/{id}", method = RequestMethod.GET)
	public List<Comments> getList(@PathVariable(value = "id") int id, Authentication authentication) {
		return commentsService.getComentsByPostId(id);
	}
	@DeleteMapping("/comment/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id, Authentication authentication) {
		commentsService.deleteById(id);

		return ResponseEntity.ok("Arquivo excluído com sucesso!");
	}
}
