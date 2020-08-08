package com.frwk.blog.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.frwk.blog.dto.CommentsDto;
import com.frwk.blog.entity.Comments;
import com.frwk.blog.entity.User;
import com.frwk.blog.exception.FileStorageException;
import com.frwk.blog.repository.ComemntsRepository;
/**
 * Classe de serviços para acesso aos comentários.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@Service
public class CommentsService {
	@Autowired
	private ComemntsRepository comemntsRepository;
	public List<Comments> getComentsByPostId(int postId){
		List<Comments> listaComents = comemntsRepository.findComentsByPostId(postId);
		return listaComents; 
	}
	public Comments addComent(CommentsDto comentData, User user) {
		Comments coment = new Comments();
		coment.setComments(comentData.getComment());
		coment.setUserId(user.getId());
		coment.setPostId(comentData.getPostId());
		coment.setCreate_date(LocalDateTime.now());
        return comemntsRepository.save(coment);
		
	}
	public void deleteById(int id) {
		comemntsRepository.deleteById(id);
	}
}
