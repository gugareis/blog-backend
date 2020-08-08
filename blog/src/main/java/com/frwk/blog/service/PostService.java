package com.frwk.blog.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.frwk.blog.dto.PostDto;
import com.frwk.blog.entity.Post;
import com.frwk.blog.entity.User;
import com.frwk.blog.exception.FileStorageException;
import com.frwk.blog.repository.PostRepository;
/**
 * Classe de serviços para acesso aos posts.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	final String IMAGE_LOCATION = "C:\\Users\\gugar\\downloadFile\\";//caminho diretorio dev
	public List<Post> getListPost(){
		List<Post> listaPosts =  (List<Post>) postRepository.findAll();
		return listaPosts;
	}
	public Post addPost(PostDto postData, User user) {
		String fileName = System.currentTimeMillis() + StringUtils.cleanPath(postData.getData().getOriginalFilename());
		Post post = new Post();
		post.setPost(postData.getPost());
		post.setLink(postData.getLink());
		post.setUserId(user.getId());
		post.setCreate_date(LocalDateTime.now());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path fileNameAndPath = Paths.get(IMAGE_LOCATION, fileName);
            Files.write(fileNameAndPath, postData.getData().getBytes());
            post.setData(postData.getData().getBytes());
            post.setFileName(fileName);
            post.setFileType(postData.getData().getContentType());

            return postRepository.save(post);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
        }
		
	}
	public void deleteById(int id) {
		postRepository.deleteById(id);
	}
}
