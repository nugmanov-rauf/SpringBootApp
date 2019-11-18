package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Spring2Application;
import com.example.demo.model.User;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Spring2Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@Autowired
	private UserController userController;
	
	@Autowired 
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void retrieveAllUsers() {
		ResponseEntity<List<User>> users = userController.getAll();
		assertEquals(10, users.getBody().size());
	}
	
	@Test
	public void retriveOneUser() {
		ResponseEntity users = testRestTemplate.getForEntity("/retrieveOne/7",  User.class);
		User subject = (User) users.getBody();
		
		assertEquals("Kurtis Weissnat", subject.getName());
	}
}
