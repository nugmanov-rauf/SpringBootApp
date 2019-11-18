package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@RestController
public class UserController {
	final String URL_TO_CALL = "http://jsonplaceholder.typicode.com/users";
	
	@Resource(name ="restTemplate")
	private RestTemplate restTemplate;
	public List<User> getUsers(){
		User[] users = null;
		users = restTemplate.getForObject(URL_TO_CALL, User[].class);
		return Arrays.asList(users);
	}
	@GetMapping("retrieveAll")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok().body(getUsers());
	}
	@GetMapping("retrieveOne/{ID}")
	public ResponseEntity<User> getUser(@PathVariable("ID") String id){
		List<User> users = getUsers();
		for(User usr:users) {
			if(usr.getId()==Integer.parseInt(id)) {
				return ResponseEntity.ok().body(usr);
			}
		}
		return null;
	}
	
}
