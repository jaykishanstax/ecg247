package com.ecg.web.ecgonline.service;

import com.ecg.web.ecgonline.entity.User;
import com.ecg.web.ecgonline.entity.dto.LoginDto;

public interface ILoginService {

	User login(LoginDto loginDto);

}
