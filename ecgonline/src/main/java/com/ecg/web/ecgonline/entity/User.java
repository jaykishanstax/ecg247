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
