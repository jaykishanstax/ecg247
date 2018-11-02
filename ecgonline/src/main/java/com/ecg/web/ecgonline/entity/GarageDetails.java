package com.ecg.web.ecgonline.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "garage_details")
public class GarageDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "shop_reg_no")
	private String shopRegistrationNumber; 
    @Column(name = "shop_name")
	private String shopName; 
    @Column(name = "shop_add")
	private String shopAddress; 
    @Column(name = "creation_time")
	private int ownerId;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "modification_time")
    private LocalDateTime modificationTime;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopRegistrationNumber() {
		return shopRegistrationNumber;
	}
	public void setShopRegistrationNumber(String shopRegistrationNumber) {
		this.shopRegistrationNumber = shopRegistrationNumber;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
}

