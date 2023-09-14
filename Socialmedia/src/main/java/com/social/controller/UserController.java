package com.social.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@PostMapping("app/post-message")
	public ResponseEntity<String> postMessageHandler(@RequestBody message)
	{
		String msg = service.postMessage(message);
		
		new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
}
