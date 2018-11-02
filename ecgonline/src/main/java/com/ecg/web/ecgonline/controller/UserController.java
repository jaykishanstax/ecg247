package com.ecg.web.ecgonline.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.LoginDto;
import com.ecg.web.ecgonline.entity.dto.UserDto;
import com.ecg.web.ecgonline.service.ILoginService;
import com.ecg.web.ecgonline.service.IUserService;


@RestController
@RequestMapping("api/")
public class UserController {

	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IUserService userService;

	 @RequestMapping(value = "ping", method = RequestMethod.GET)
	    public ResponseEntity ping(final HttpServletRequest request) {
	        return ResponseEntity.ok("pong");
	    }
	 
	 @PostMapping(value = "/login")
	    public ResponseEntity login(@RequestBody LoginDto loginDto,
	                                @RequestHeader(value = "Origin") String origin) {
	        User user = loginService.login(loginDto);
	        
	        if(user == null) {
	        	return ResponseEntity.ok("Email id or password is invalid");
	        } else {
	        	return ResponseEntity.ok("login");
	        }
	    }
	 
	 @PostMapping(value = "/registration")
	    public ResponseEntity registerUserAccount(@RequestBody @Valid UserDto user,
	                                                               HttpServletRequest request) {
	        User registeredUser = userService.registerNewUserAccount(user);
	        
	        if(registeredUser == null) {
	        	return ResponseEntity.ok("User is not created.");
	        } else {
	        	return ResponseEntity.ok("user created");
	        }
	    }
	
}
