package com.example.demo.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void getAndSets() {
		User user = User.builder().id(1).build();
		assertEquals(1, user.getId());
	}

}
