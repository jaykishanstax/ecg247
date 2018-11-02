package com.ecg.web.ecgonline.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecg.web.ecgonline.entity.ServiceRequestDetails;
import com.ecg.web.ecgonline.entity.dto.GenericResponse;
import com.ecg.web.ecgonline.entity.dto.ServiceRequestDetailsDto;
import com.ecg.web.ecgonline.enumerator.ServiceRequestStatus;
import com.ecg.web.ecgonline.service.IServiceRequest;

@RestController
@RequestMapping("api/service")
public class ServiceRequestController {

	@Autowired
	IServiceRequest serviceRequest;
	
	@PutMapping
	public ResponseEntity<GenericResponse<Map<String,String>>> register(@RequestBody ServiceRequestDetailsDto serviceRequestDetailsDto,
			final HttpServletRequest request) {
		String messageString = null;
		Map<String,String> message = new HashMap<>();
		ServiceRequestDetails serviceRequestDetails =  new ServiceRequestDetails();
		GenericResponse<Map<String,String>> response = new GenericResponse<Map<String,String>>();
		if (null == serviceRequestDetailsDto.getUserId()) {
			response.setError("User can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if (null == serviceRequestDetailsDto.getGarageId()) {
			response.setError("Garage can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(!serviceRequestDetailsDto.isOtpVerified()) {
			response.setError("OTP is not verified ");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(StringUtils.isEmpty(serviceRequestDetailsDto.getBikeModelNo()) 
				|| StringUtils.isEmpty(serviceRequestDetailsDto.getBikeMfg())
				|| StringUtils.isEmpty(serviceRequestDetailsDto.getBikeRegistrationNumber())) {
			response.setError("Bike Information can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(serviceRequestDetailsDto.isPickUp() && StringUtils.isEmpty(serviceRequestDetailsDto.getPickUpAddress())) {
			response.setError("Pick Up Address can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(serviceRequestDetailsDto.isDrop() && StringUtils.isEmpty(serviceRequestDetailsDto.getDropAddress())) {
			response.setError("Drop Address can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(serviceRequestDetailsDto.isPickUp() && null == serviceRequestDetailsDto.getPickUpAt()) {
			response.setError("Pick Up Time can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(serviceRequestDetailsDto.isDrop() && null == serviceRequestDetailsDto.getDropAt()) {
			response.setError("Drop Time can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		}
		BeanUtils.copyProperties(serviceRequestDetailsDto, serviceRequestDetails);
		serviceRequestDetails.setStatus(ServiceRequestStatus.REQUESTED);
		serviceRequestDetails.setRequestedAt(LocalDateTime.now());;
		messageString = serviceRequest.save(serviceRequestDetails);
		message.put("message", messageString);
		response.setData(message);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(path = "/assignpickupboy/{serviceId}")
	public ResponseEntity<GenericResponse<Map<String,String>>> assignPickupBoy(@PathVariable(value="serviceId") Long serviceId,
            @RequestParam(value = "userId", required = true) Long userId,
			final HttpServletRequest request) {
		String messageString = null;
		Map<String,String> message = new HashMap<>();
		GenericResponse<Map<String,String>> response = new GenericResponse<Map<String,String>>();
		if (null == userId || false) {
			response.setError("User can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if (null == serviceId || null == serviceRequest.findById(serviceId)) {
			response.setError(" Service request can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} 
		messageString = serviceRequest.assignPickupBoy(serviceId, userId );
		message.put("message", messageString);
		response.setData(message);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(path = "/setservicereuqeststatus/{serviceId}")
	public ResponseEntity<GenericResponse<Map<String,String>>> setServiceReuqestStatus(@PathVariable(value="serviceId") Long serviceId,
            @RequestParam(value = "status", required = true) ServiceRequestStatus status,
			final HttpServletRequest request) {
		String messageString = null;
		Map<String,String> message = new HashMap<>();
		GenericResponse<Map<String,String>> response = new GenericResponse<Map<String,String>>();
		if (null == status ) {
			response.setError("Status can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if (null == serviceId || null == serviceRequest.findById(serviceId)) {
			response.setError(" Service request can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} 
		messageString = serviceRequest.setServiceReuqestStatus(serviceId, status );
		message.put("message", messageString);
		response.setData(message);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(path = "/completeservicereuqest/{serviceId}")
	public ResponseEntity<GenericResponse<Map<String,String>>> completeServiceReuqest(@PathVariable(value="serviceId") Long serviceId,
			final HttpServletRequest request) {
		String messageString = null;
		Map<String,String> message = new HashMap<>();
		GenericResponse<Map<String,String>> response = new GenericResponse<Map<String,String>>();
		if (null == serviceId || null == serviceRequest.findById(serviceId)) {
			response.setError(" Service request can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} 
		messageString = serviceRequest.completeServiceReuqest(serviceId );
		message.put("message", messageString);
		response.setData(message);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "/garage/{garageId}")
	public ResponseEntity<GenericResponse<List<ServiceRequestDetailsDto>>> getAllServiceRequestByGarageId(@PathVariable(value="garageId") Long garageId,
			final HttpServletRequest request) {
		GenericResponse<List<ServiceRequestDetailsDto>> response = new GenericResponse<List<ServiceRequestDetailsDto>>();
		List<ServiceRequestDetailsDto> serviceRequestDetailsDtoList =  new ArrayList<>();
		List<ServiceRequestDetails> serviceRequestDetails = serviceRequest.getAllServiceRequestByGarageId(garageId);
		serviceRequestDetails.stream().forEach(sr -> {
			ServiceRequestDetailsDto serviceRequestDetailsDto = new ServiceRequestDetailsDto();
			BeanUtils.copyProperties(sr, serviceRequestDetailsDto);
			serviceRequestDetailsDtoList.add(serviceRequestDetailsDto);
		});
		response.setData(serviceRequestDetailsDtoList);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "/{serviceId}")
	public ResponseEntity<GenericResponse<ServiceRequestDetailsDto>> getServiceRequest(@PathVariable(value="serviceId") Long serviceId,
			final HttpServletRequest request) {
		GenericResponse<ServiceRequestDetailsDto> response = new GenericResponse<ServiceRequestDetailsDto>();
		ServiceRequestDetails serviceRequestDetails = serviceRequest.findById(serviceId);
		ServiceRequestDetailsDto serviceRequestDetailsDto = new ServiceRequestDetailsDto();
		BeanUtils.copyProperties(serviceRequestDetails, serviceRequestDetailsDto);
		response.setData(serviceRequestDetailsDto);
		return ResponseEntity.ok(response);
	}
}
