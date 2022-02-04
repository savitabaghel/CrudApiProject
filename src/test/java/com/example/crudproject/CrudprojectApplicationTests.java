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
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
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
    @Test
	public void getByIdTest()
	{
		user user1=new user();
		user1.setId(31);
		user1.setFirstname("koel");
		user1.setLastname("bagh");
		user1.setEmailid("savi@12345");
		user1.setMobileno(563324);
		user1.setAddress1("usa");
		user1.setAddress2("kael");
		user1.setCdate(new Date());
		user1.setUdate(new Date());

		when(userrepository.findById(31)).thenReturn(user1);
		assertThat(userService.getoneuser(31)).isEqualTo(user1);
	}
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
		//verify(userrepository,times(1)).deleteById(12);
		user optional = userrepository.findById(12);
		assertEquals(null, optional);

	}
	@Test
	public void updateUserTest()
	{
		user user1=new user();
		user1.setId(32);
		user1.setFirstname("koel");
		user1.setLastname("bagh");
		user1.setEmailid("savi@12345");
		user1.setMobileno(56343);
		user1.setAddress1("usa");
		user1.setAddress2("kael");
		user1.setCdate(new Date());
		user1.setUdate(new Date());

		when(userrepository.findById(32)).thenReturn(user1);

		user1.setFirstname("gloye");
		when(userrepository.save(user1)).thenReturn(user1);

		assertThat(userService.updateuser(user1,32)).isEqualTo(user1);
	}

}
