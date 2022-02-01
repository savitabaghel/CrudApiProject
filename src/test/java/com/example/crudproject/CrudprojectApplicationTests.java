package com.example.crudproject;

import com.example.crudproject.model.user;
import com.example.crudproject.repository.userRepository;
import com.example.crudproject.service.UserService;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest

class CrudprojectApplicationTests {




	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@MockBean
	private userRepository userrepository;

	@Test
	public void getUserTest()
	{
		when(userrepository.findAll()).thenReturn((Iterable<user>) Stream.of(new user(20,
				"xyz",
				"sav",
				"savi@123",
				9876,
				"bhind",
				"mp",
				null,
				null)).collect(Collectors.toList()));

        assertEquals(1,userService.getAlluser().size());


	}
//	@Test
//	public void getUserByIdTest()
//	{
//		int id=24;
//		when(userrepository.findById(id)).thenReturn((user) Stream.of(new user(21,"xyz","sav","sav@123",4563,"bhind","mp",null,null)));
//		assertEquals(id,userService.getoneuser(id).);
//	}
	@Test
	public void saveUserTest()
	{
		user user1=new user(12,"man","ban","man@123",7865,"sac","usa",null,null);
		when(userrepository.save(user1)).thenReturn(user1);
		assertEquals(user1,userService.adduser(user1));
	}

	@Test
	public void deleteUserTest()
	{
		user user1=new user(12,"man","ban","man@123",7865,"sac","usa",null,null);
		userService.deluser(12);
		verify(userrepository,times(1)).deleteById(12);

	}

}
