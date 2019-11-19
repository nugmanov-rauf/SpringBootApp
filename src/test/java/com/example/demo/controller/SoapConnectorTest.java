package com.example.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Spring2Application;
import com.example.demo.controller.SoapConnector;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Spring2Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class SoapConnectorTest {
	
	@Autowired
	SoapConnector classUnderTest;
	
	@Test
	public void testAdd() {
		assertEquals(7, classUnderTest.add(2,5));
		
	}

}
