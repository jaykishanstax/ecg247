package com.ecg.web.ecgonline.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {


	 @RequestMapping(value = "ping", method = RequestMethod.GET)
	    public ResponseEntity ping(final HttpServletRequest request) {
	        return ResponseEntity.ok("pong");
	    }
	
}
