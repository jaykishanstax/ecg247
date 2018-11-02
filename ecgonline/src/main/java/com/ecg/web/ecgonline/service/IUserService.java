package com.ecg.web.ecgonline.service;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.UserDto;

public interface IUserService {

	public User registerNewUserAccount(UserDto userDto);

}
