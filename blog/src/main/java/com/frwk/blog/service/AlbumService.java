package com.frwk.blog.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.frwk.blog.dto.AlbumListDto;
import com.frwk.blog.entity.Album;
import com.frwk.blog.entity.User;
import com.frwk.blog.exception.FileStorageException;
import com.frwk.blog.repository.AlbumRepository;
/**
 * Classe de serviços para acesso aos dados dos albuns.
 * @author Gustavo Reis de Paiva
 * @version 0.0.1
 */
@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	final String IMAGE_LOCATION = "C:\\Users\\gugar\\downloadFile\\";//caminho diretorio dev
	public List<Album> getList(){
		return (List<Album>) albumRepository.findAll();
	}

	public List<Album> getListByUserId(int userId){
		return (List<Album>) albumRepository.findByUserId(userId);
	}
	public void addAlbum(AlbumListDto albumList, User user) {
		for (MultipartFile list : albumList.getData()) {
			String fileName = System.currentTimeMillis() + StringUtils.cleanPath(list.getOriginalFilename());
			Album album = new Album();
			album.setUserId(user.getId());
			try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }
	            album.setData(list.getBytes());
	            album.setFileName(fileName);
	            album.setFileType(list.getContentType());

	            albumRepository.save(album);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
	        }
		}
	}
	public void deleteAlbumByUserId(int userId) {
		albumRepository.deleteByUserId(userId);
	}
}
