package com.ecg.web.ecgonline.entity.dto;

import java.time.LocalDateTime;

import org.springframework.validation.annotation.Validated;

import com.ecg.web.ecgonline.enumerator.UserRole;
import com.ecg.web.ecgonline.enumerator.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

	public int id;
    
    public String email;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getMobileNumberPrimary() {
		return mobileNumberPrimary;
	}

	public void setMobileNumberPrimary(String mobileNumberPrimary) {
		this.mobileNumberPrimary = mobileNumberPrimary;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String userName;
    
    public String password;
    
    private UserStatus status;
    
    private String mobileNumberPrimary;
    
    private String licenceNo;
    
    private UserRole userRole;
    
    private LocalDateTime creationTime;
    
    private LocalDateTime modificationTime;


}
