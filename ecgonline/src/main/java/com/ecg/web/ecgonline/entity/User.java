package com.ecg.web.ecgonline.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecg.web.ecgonline.enumerator.UserRole;
import com.ecg.web.ecgonline.enumerator.UserStatus;


@Entity
@Table(name = "user")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    
    @Column(name = "email")
    public String email;
    
    @Column(name = "name", length = 100)
    public String userName;
    
    @Column(name = "password", length = 100)
    public String password;
    
    public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;
    
    @Column(name = "mobile_number", length = 20)
    private String mobileNumberPrimary;
    
    @Column(name = "licence_no", length = 30)
    private String licenceNo;
    
    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    
    @Column(name="creation_time")
    private LocalDateTime creationTime;
    
    @Column(name="modification_time")
    private LocalDateTime modificationTime;

}
