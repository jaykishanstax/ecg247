package com.ecg.web.ecgonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.LoginDto;
import com.ecg.web.ecgonline.repository.UserRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(LoginDto loginDto) {
		String email = loginDto.getEmail();
		if (null == email) {
			User user = userRepository.findUserByMobileNumberPrimary(loginDto.getMobileNumberPrimary());
			email = user.getEmail();
		}
		Authentication request = new UsernamePasswordAuthenticationToken(email, loginDto.getPassword());
		User userByEmail = userRepository.findUserByEmail(email);
		if (request.getCredentials().toString().equals(userByEmail.getEmail())) {
			return userByEmail;
		} else {
			return null;
		}
	}
}
