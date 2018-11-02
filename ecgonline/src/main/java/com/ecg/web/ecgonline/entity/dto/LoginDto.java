package com.ecg.web.ecgonline.entity.dto;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class LoginDto {

    private String email;

    @NotBlank(message = "password can not be null")
    private String password;

    private String mobileNumberPrimary;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumberPrimary() {
		return mobileNumberPrimary;
	}

	public void setMobileNumberPrimary(String mobileNumberPrimary) {
		this.mobileNumberPrimary = mobileNumberPrimary;
	}
}
