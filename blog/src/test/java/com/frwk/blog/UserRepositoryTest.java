package com.frwk.blog;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

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
//		String originalInput = "123456";
//		String encodedPassword = Base64.getEncoder().encodeToString(originalInput.getBytes());
//		User usersSave = new User();
//		usersSave.setName("guga");
//		usersSave.setEmail("guga@blog.com");
//		usersSave.setPassword(encodedPassword);
//		usersSave.setCreate_date(LocalDateTime.now());
//		userRepository.save(usersSave);
		//User savedUser = registerUseCase.registerUser(users);
		//when
		User users =  userRepository.findByEmail("guga@blog.com"); 
		//then
//		for(User p : users){ 
//
//			System.out.println(p.getName());
//			  assertEquals(p.getName(),"Cassandra");
//			 
//			  //count++;
//		  }
		System.out.println(users.getName());
		  assertEquals(users.getName(),"guga");
	}
}
