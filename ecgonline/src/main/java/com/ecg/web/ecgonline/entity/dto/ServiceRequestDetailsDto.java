package com.ecg.web.ecgonline.entity.dto;

import java.time.LocalDateTime;

import com.ecg.web.ecgonline.enumerator.ServiceRequestStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRequestDetailsDto {
	private Long id;
	private Long userId;
	private Long garageId;
	private ServiceRequestStatus status;
	private String paymentMode;
	@JsonProperty
	private boolean isOtpVerified;
	private String bikeModelNo;
	private String bikeMfg;
	private String bikeRegistrationNumber;
	private Long pickupUserId;
	@JsonProperty
	private boolean isPickUp;
	@JsonProperty
	private boolean isDrop;
	private String pickUpAddress;
	private String dropAddress;
	private LocalDateTime pickUpAt;
	private LocalDateTime dropAt;
	private LocalDateTime requestedAt;
	private LocalDateTime completedAt;
	private String description;
	private LocalDateTime creationTime;
	private LocalDateTime modificationTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGarageId() {
		return garageId;
	}
	public void setGarageId(Long garageId) {
		this.garageId = garageId;
	}
	public ServiceRequestStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceRequestStatus status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public boolean isOtpVerified() {
		return isOtpVerified;
	}
	public void setOtpVerified(boolean isOtpVerified) {
		this.isOtpVerified = isOtpVerified;
	}
	public String getBikeModelNo() {
		return bikeModelNo;
	}
	public void setBikeModelNo(String bikeModelNo) {
		this.bikeModelNo = bikeModelNo;
	}
	public String getBikeMfg() {
		return bikeMfg;
	}
	public void setBikeMfg(String bikeMfg) {
		this.bikeMfg = bikeMfg;
	}
	public String getBikeRegistrationNumber() {
		return bikeRegistrationNumber;
	}
	public void setBikeRegistrationNumber(String bikeRegistrationNumber) {
		this.bikeRegistrationNumber = bikeRegistrationNumber;
	}
	public Long getPickupUserId() {
		return pickupUserId;
	}
	public void setPickupUserId(Long pickupUserId) {
		this.pickupUserId = pickupUserId;
	}
	public boolean isPickUp() {
		return isPickUp;
	}
	public void setPickUp(boolean isPickUp) {
		this.isPickUp = isPickUp;
	}
	public boolean isDrop() {
		return isDrop;
	}
	public void setDrop(boolean isDrop) {
		this.isDrop = isDrop;
	}
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}
	public String getDropAddress() {
		return dropAddress;
	}
	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}
	public LocalDateTime getPickUpAt() {
		return pickUpAt;
	}
	public void setPickUpAt(LocalDateTime pickUpAt) {
		this.pickUpAt = pickUpAt;
	}
	public LocalDateTime getDropAt() {
		return dropAt;
	}
	public void setDropAt(LocalDateTime dropAt) {
		this.dropAt = dropAt;
	}
	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}
	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
