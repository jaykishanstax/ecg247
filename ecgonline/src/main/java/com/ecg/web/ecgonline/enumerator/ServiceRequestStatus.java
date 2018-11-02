package com.ecg.web.ecgonline.enumerator;

public enum ServiceRequestStatus {
	REQUESTED("Requested"), 
	IN_PROCESS("In Process"), 
	COMPLETED("Completed"), 
	CANCELED("Canceled");
    private String serviceRequestStatus;

    public String getServiceRequestStatus() {
		return serviceRequestStatus;
	}

	ServiceRequestStatus(String serviceRequestStatus) {
        this.serviceRequestStatus = serviceRequestStatus;
    }
}
