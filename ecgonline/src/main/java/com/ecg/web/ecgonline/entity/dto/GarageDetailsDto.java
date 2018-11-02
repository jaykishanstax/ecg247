package com.ecg.web.ecgonline.entity.dto;

import java.time.LocalDateTime;

public class GarageDetailsDto {

	private Long id;
	private String shopRegistrationNumber; 
	private String shopName; 
	private String shopAddress; 
	private Long ownerId;
    private LocalDateTime creationTime;
	private LocalDateTime modificationTime;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
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
