package com.frwk.blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frwk.blog.entity.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{
	List<Album> findByUserId(int userId);

	void deleteByUserId(int userId);
}
