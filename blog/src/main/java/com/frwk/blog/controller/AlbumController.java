package com.frwk.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frwk.blog.dto.AlbumListDto;
import com.frwk.blog.entity.Album;
import com.frwk.blog.entity.User;
import com.frwk.blog.service.AlbumService;
import com.frwk.blog.service.UserService;
/**
 * Classe controle de acesso Rest de dados dos albuns.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@RestController
@CrossOrigin(origins = "*")
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/album/add", method = RequestMethod.POST,
	        consumes = {"multipart/form-data"})
	public ResponseEntity<?> addAlbum(@ModelAttribute AlbumListDto albumListDto,Authentication authentication) {
		final User user = userService.getUserByUserName(authentication.getName());
		albumService.addAlbum(albumListDto,user);

		return ResponseEntity.ok("Arquivo gravado com sucesso!");
	}

	@RequestMapping(value = "/album/list/{id}", method = RequestMethod.GET)
	public List<Album> getListByUserId(@PathVariable(value = "id") int id, Authentication authentication) {
		return albumService.getListByUserId(id);
	}
	@RequestMapping(value = "/album/list", method = RequestMethod.GET)
	public List<Album> getList(Authentication authentication) {
		return albumService.getList();
	}
	@DeleteMapping("/album/delete/{id}") 
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") int id, Authentication authentication) {
		albumService.deleteAlbumByUserId(id);

		return ResponseEntity.ok("Arquivo excluído com sucesso!");
	}
}
