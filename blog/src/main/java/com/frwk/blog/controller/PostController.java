package com.frwk.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frwk.blog.dto.AuthResponseDto;
import com.frwk.blog.dto.PostDto;
import com.frwk.blog.entity.Post;
import com.frwk.blog.entity.User;
import com.frwk.blog.service.PostService;
import com.frwk.blog.service.UserService;
/**
 * Classe controle de acesso Rest de dados dos posts.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@RequestMapping(value = "post/add", method = RequestMethod.POST,
	        consumes = {"multipart/form-data"})
	public ResponseEntity<?> addPost(@ModelAttribute PostDto postDto,Authentication authentication) {
		final User user = userService.getUserByUserName(authentication.getName());
		postService.addPost(postDto, user);

		return ResponseEntity.ok("Arquivo gravado com sucesso!");
	}
	
	@RequestMapping(value = "/post/list", method = RequestMethod.GET)
	public List<Post> getListPost(Authentication authentication) {
		return postService.getListPost();
	}
	@DeleteMapping("/post/delete/{id}") 
	public ResponseEntity<?> deleteById(@PathVariable int id, Authentication authentication) {
		postService.deleteById(id);
		return ResponseEntity.ok("Arquivo excluído com sucesso!");
	}
}