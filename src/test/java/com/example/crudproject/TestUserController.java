package com.example.crudproject;

import com.example.crudproject.controller.userController;
import com.example.crudproject.model.user;
import com.example.crudproject.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUserController {

    @Mock
    private UserService userService;

    private user user1;

    private List<user>userList;

    @InjectMocks
    private userController usercontroller;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        user1=new user(1,"savi","bagh","savi@123",4352,"bhind","mp",new Date(),new Date());
        mockMvc= MockMvcBuilders.standaloneSetup(usercontroller).build();
    }
    @AfterEach
    void tearDown()
    {
        user1=null;
    }

    @Test
    public void createUserTest()throws Exception
    {
        when(userService.adduser(any())).thenReturn(user1);
        mockMvc.perform(post("/u/api").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user1))).andExpect(status().isCreated());
        verify(userService,times(1)).adduser(any());
    }

    @Test
    public void deleteUserTest() throws Exception
    {
        when(userService.deluser(user1.getId())).thenReturn(user1);
        mockMvc.perform(delete("/u/api/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user1))).andExpect(status().isOk());
    }

    @Test
    public void getUserByIdTest()throws Exception
    {
        when(userService.getoneuser(user1.getId())).thenReturn(user1);
        mockMvc.perform(get("/u/api/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user1))).andExpect(status().isOk());
    }



    public static String asJsonString(final Object obj)
    {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
