package com.ecg.web.ecgonline.service;

import java.util.List;

import com.ecg.web.ecgonline.entity.ServiceRequestDetails;
import com.ecg.web.ecgonline.enumerator.ServiceRequestStatus;

public interface IServiceRequest {

	String save(ServiceRequestDetails serviceRequestDetails);

	String assignPickupBoy(Long serviceId, Long userId);

	ServiceRequestDetails findById(Long serviceId);

	String setServiceReuqestStatus(Long serviceId, ServiceRequestStatus status);

	String completeServiceReuqest(Long serviceId);

	List<ServiceRequestDetails> getAllServiceRequestByGarageId(Long garageId);

	List<ServiceRequestDetails> getAllServiceRequestByUserId(Long userId);

}
