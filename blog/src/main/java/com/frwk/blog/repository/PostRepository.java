package com.frwk.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frwk.blog.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
