package com.ecg.web.ecgonline.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecg.web.ecgonline.entity.GarageDetails;
import com.ecg.web.ecgonline.entity.dto.GarageDetailsDto;
import com.ecg.web.ecgonline.service.IGarageService;

@RestController
@RequestMapping("api/")
public class GarageController {

	@Autowired
	IGarageService garageService;
	
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public ResponseEntity ping(final HttpServletRequest request) {
		return ResponseEntity.ok("pong");
	}
	
	@PutMapping
	public ResponseEntity<Map<String,String>> register(GarageDetailsDto garageDetailsDto,
			final HttpServletRequest request) {
		GarageDetails garageDetails =  new GarageDetails();
		BeanUtils.copyProperties(garageDetailsDto, garageDetails);
		String messageString = garageService.register(garageDetails);
		Map<String,String> message = new HashMap<>();
		return ResponseEntity.ok(message);
	}
}
