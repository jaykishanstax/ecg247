package com.ecg.web.ecgonline.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecg.web.ecgonline.entity.GarageDetails;
import com.ecg.web.ecgonline.entity.dto.GarageDetailsDto;
import com.ecg.web.ecgonline.entity.dto.GenericResponse;
import com.ecg.web.ecgonline.service.IGarageService;

@RestController
@RequestMapping("api/garage")
public class GarageController {

	@Autowired
	IGarageService garageService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> ping(final HttpServletRequest request) {
		return ResponseEntity.ok("pong");
	}
	
	@PutMapping
	public ResponseEntity<GenericResponse<Map<String,String>>> register(@RequestBody GarageDetailsDto garageDetailsDto,
			final HttpServletRequest request) {
		String messageString = null;
		Map<String,String> message = new HashMap<>();
		GarageDetails garageDetails =  new GarageDetails();
		GenericResponse<Map<String,String>> response = new GenericResponse<Map<String,String>>();
		if (null == garageDetailsDto.getOwnerId()) {
			response.setError("Garage Owner can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(StringUtils.isEmpty(garageDetailsDto.getShopAddress())) {
			response.setError("Garage Address can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(StringUtils.isEmpty(garageDetailsDto.getShopName())) {
			response.setError("Garage Name can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		} else if(StringUtils.isEmpty(garageDetailsDto.getShopRegistrationNumber())) {
			response.setError("Garage Registration Number can not be empty");
			return new ResponseEntity<GenericResponse<Map<String,String>>>(response, HttpStatus.BAD_REQUEST);
		}
		BeanUtils.copyProperties(garageDetailsDto, garageDetails);
		messageString = garageService.register(garageDetails);
		message.put("message", messageString);
		response.setData(message);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<GenericResponse<List<GarageDetailsDto>>> getAll(
            @RequestParam(value = "query", required = false) String query,
			final HttpServletRequest request) {
        query = (query == null || query.trim().isEmpty()) ? "%" : "%" + query + "%";
		GenericResponse<List<GarageDetailsDto>> response = new GenericResponse<List<GarageDetailsDto>>();
		List<GarageDetailsDto> garageDetailsDtoList =  new ArrayList<>();
		List<GarageDetails> garageDetails = garageService.getAll(query);
		garageDetails.stream().forEach(gd -> {
			GarageDetailsDto garageDetailsDto = new GarageDetailsDto();
			BeanUtils.copyProperties(gd, garageDetailsDto);
			garageDetailsDtoList.add(garageDetailsDto);
		});
		response.setData(garageDetailsDtoList);
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = "/{garageId}")
	public ResponseEntity<GenericResponse<GarageDetailsDto>> get(@PathVariable(value="garageId") Long garageId,
			final HttpServletRequest request) {
		GenericResponse<GarageDetailsDto> response = new GenericResponse<GarageDetailsDto>();
		GarageDetailsDto garageDetailsDto =  new GarageDetailsDto();
		GarageDetails garageDetails = garageService.get(garageId);
		BeanUtils.copyProperties(garageDetails, garageDetailsDto);
		response.setData(garageDetailsDto);
		return ResponseEntity.ok(response);
	}
}
