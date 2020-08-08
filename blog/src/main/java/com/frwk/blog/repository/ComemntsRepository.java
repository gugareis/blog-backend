package com.frwk.blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frwk.blog.entity.Comments;


@Repository
public interface ComemntsRepository extends CrudRepository<Comments, Integer> {

	List<Comments> findComentsByPostId(int postId);
}
