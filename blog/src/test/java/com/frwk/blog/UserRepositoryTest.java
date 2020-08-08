package com.frwk.blog;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.frwk.blog.entity.User;
import com.frwk.blog.repository.UserRepository;


@RunWith(SpringRunner.class)

@SpringBootTest
@Service
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	@Transactional
	public void testFetchData() {
		/* Test data retrieval */
		//given
		String senha =  "123456";
		User usersSave = new User();
		usersSave.setUserName("gugar");
		usersSave.setName("gugar");
		usersSave.setEmail("gugar@blog.com");
		usersSave.setPassword(DigestUtils.sha256Hex(senha));
		usersSave.setCreate_date(LocalDateTime.now());
		userRepository.save(usersSave);
		//when
		User users =  userRepository.findByEmail("gugar@blog.com"); 
		//thenCC
		System.out.println(users.getUserName());
		  assertEquals(users.getUserName(),"gugar");
	}
}
