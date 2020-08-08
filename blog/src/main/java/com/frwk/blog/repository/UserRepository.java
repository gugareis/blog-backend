package com.frwk.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frwk.blog.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

	User findByUserName(String userName);
}
