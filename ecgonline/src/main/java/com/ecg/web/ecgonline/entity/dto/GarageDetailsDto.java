package com.ecg.web.ecgonline.entity.dto;

import java.time.LocalDateTime;

public class GarageDetailsDto {

	private int id;
	private String shopRegistrationNumber; 
	private String shopName; 
	private String shopAddress; 
	private int ownerId;
    private LocalDateTime creationTime;
    
    
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
	private LocalDateTime modificationTime;
	
}
