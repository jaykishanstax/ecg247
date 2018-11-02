package com.ecg.web.ecgonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.UserDto;
import com.ecg.web.ecgonline.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerNewUserAccount(UserDto userDto) {

		User user = userRepository.findUserByEmail(userDto.getEmail());
		
		User user2 = userRepository.findUserByMobileNumberPrimary(userDto.getMobileNumberPrimary());

		if (user != null || user2 != null) {
			throw new RestClientException("User Already exisit");
		} else {
			user = new User();
			user.setFullName(userDto.getFullName());
			// user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user.setPassword(userDto.getPassword());
			user.setEmail(userDto.getEmail());
			user.setMobileNumberPrimary(userDto.getMobileNumberPrimary());
			user.setUserRole(userDto.getUserRole());
			user.setStatus(userDto.getStatus());
		}

		return userRepository.save(user);

	}
}
