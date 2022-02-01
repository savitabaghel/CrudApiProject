package com.example.crudproject;


import com.example.crudproject.model.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.sql.Timestamp;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.MULTI_STATUS;

@SpringBootTest(classes = CrudprojectApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers= new HttpHeaders();


    @Test
    public void createUserTest()throws Exception{

        user user1= new user();
        user1.setId(91);
        user1.setFirstname("savi");
        user1.setLastname("bagh");
        user1.setEmailid("savi@12345");
        user1.setMobileno(567423);
        user1.setAddress1("usa");
        user1.setAddress2("kael");
        user1.setCreatedate(  new Timestamp(new Date().getTime()));
        user1.setUpdatedate(new Timestamp(new Date().getTime()) );

        String URIToCreateUser="/u/api";

        String inputInJson=this.mapToJson(user1);

        HttpEntity<user>entity=new HttpEntity<user>(user1,headers);

        ResponseEntity<String>response=testRestTemplate.exchange(fullFormURLWithPort(URIToCreateUser), HttpMethod.POST,entity,String.class);

        String responseInJson=response.getBody();


        assertEquals(HttpStatus.CREATED.value(),response.getStatusCode().value());

    }
//    @Test
//    public void getByIdTest() throws Exception{
//        user user1=new user();
//        user1.setId(30);
//        user1.setFirstname("savi");
//        user1.setLastname("bagh");
//        user1.setEmailid("savi@12345");
//        user1.setMobileno(123458);
//        user1.setAddress1("usa");
//        user1.setAddress2("kael");
//        user1.setCreatedate( new Timestamp(new Date().getTime()));
//        user1.setUpdatedate(new Timestamp(new Date().getTime()) );
//
//        String URIToCreateUser="/u/api";
//
//        String inputInJson=this.mapToJson(user1);
//
//
//        HttpEntity<user>entity=new HttpEntity<user>(user1,headers);
//        testRestTemplate.exchange(fullFormURLWithPort(URIToCreateUser), HttpMethod.POST,entity,String.class);
//        String URI="/u/api/30";
//
//         String response=testRestTemplate.getForObject(fullFormURLWithPort(URI),String.class);
//
//        assertThat(response).isEqualTo(inputInJson);
//
//
//
//    }
//



    private String mapToJson(Object object)throws JsonProcessingException{
        ObjectMapper objectMapper =new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    private String fullFormURLWithPort(String uri)
    {
        return "http://localhost:"+port+uri;
    }
}
