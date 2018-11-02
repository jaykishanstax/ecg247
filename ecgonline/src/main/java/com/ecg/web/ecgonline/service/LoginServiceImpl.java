package com.ecg.web.ecgonline.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.LoginDto;
import com.ecg.web.ecgonline.repository.UserRepository;


public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(LoginDto loginDto) {

        String email = loginDto.getEmail();
        Authentication request = new UsernamePasswordAuthenticationToken(email, loginDto.getPassword());
        
        User userByEmail = userRepository.findUserByEmail(email);
        
        if (passwordEncoder.matches(request.getCredentials().toString(), userByEmail.getEmail())) {
            
            return userByEmail;

        }
        else {
        	return null;
        }
        
        
	}


}
