package com.ecg.web.ecgonline.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecg.web.ecgonline.enumerator.ServiceRequestStatus;

@Entity
@Table(name = "service_request_details")
public class ServiceRequestDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "garage_id")
	private Long garageId;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ServiceRequestStatus status;
	@Column(name = "payment_mode")
	private String paymentMode;
	@Column(name = "is_otp_verified")
	private boolean isOtpVerified;
	@Column(name = "bike_model_no")
	private String bikeModelNo;
	@Column(name = "bike_mfg")
	private String bikeMfg;
	@Column(name = "bike_reg_no")
	private String bikeRegistrationNumber;
	@Column(name = "pickup_user_id")
	private Long pickupUserId;
	@Column(name = "is_pick_up")
	private boolean isPickUp;
	@Column(name = "is_drop")
	private boolean isDrop;
	@Column(name = "pick_up_add")
	private String pickUpAddress;
	@Column(name = "drop_add")
	private String dropAddress;
	@Column(name = "pick_up_at")
	private LocalDateTime pickUpAt;
	@Column(name = "drop_at")
	private LocalDateTime dropAt;
	@Column(name = "requested_at")
	private LocalDateTime requestedAt;
	@Column(name = "completed_at")
	private LocalDateTime completedAt;
	@Column(name = "description")
	private String description;
	@Column(name = "creation_time", updatable = false, insertable = false)
	private LocalDateTime creationTime;
	@Column(name = "modification_time", updatable = false, insertable = false)
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
