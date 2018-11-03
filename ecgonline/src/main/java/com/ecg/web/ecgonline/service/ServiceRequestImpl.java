package com.ecg.web.ecgonline.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecg.web.ecgonline.entity.ServiceRequestDetails;
import com.ecg.web.ecgonline.enumerator.ServiceRequestStatus;
import com.ecg.web.ecgonline.repository.ServiceRequestDetailsRepository;

@Service
public class ServiceRequestImpl implements IServiceRequest {

	@Autowired
	ServiceRequestDetailsRepository serviceRequestDetailsRepository;

	@Override
	public String save(ServiceRequestDetails serviceRequestDetails) {
		serviceRequestDetailsRepository.save(serviceRequestDetails);
		return "Service Request Registered successfully";
	}

	@Override
	public String assignPickupBoy(Long serviceId, Long userId) {
		ServiceRequestDetails serviceRequestDetails = findById(serviceId);
		serviceRequestDetails.setPickupUserId(userId);
		serviceRequestDetailsRepository.save(serviceRequestDetails);
		return "Service Request successfully Assigned to pick up Boy";
	}

	@Override
	public ServiceRequestDetails findById(Long serviceId) {
		return serviceRequestDetailsRepository.findById(serviceId).get();
	}

	@Override
	public String setServiceReuqestStatus(Long serviceId, ServiceRequestStatus status) {
		ServiceRequestDetails serviceRequestDetails = findById(serviceId);
		serviceRequestDetails.setStatus(status);
		serviceRequestDetailsRepository.save(serviceRequestDetails);
		return "Service Request successfully updated";
	}

	@Override
	public String completeServiceReuqest(Long serviceId) {
		ServiceRequestDetails serviceRequestDetails = findById(serviceId);
		serviceRequestDetails.setStatus(ServiceRequestStatus.COMPLETED);
		serviceRequestDetails.setCompletedAt(LocalDateTime.now());
		serviceRequestDetailsRepository.save(serviceRequestDetails);
		return "Service Request successfully Completed";
	}

	@Override
	public List<ServiceRequestDetails> getAllServiceRequestByGarageId(Long garageId) {
		return serviceRequestDetailsRepository.findByGarageId(garageId);
	}

	@Override
	public List<ServiceRequestDetails> getAllServiceRequestByUserId(Long userId) {
		return serviceRequestDetailsRepository.findByUserId(userId);
	}

}
