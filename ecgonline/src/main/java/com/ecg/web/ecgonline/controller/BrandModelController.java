package com.ecg.web.ecgonline.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecg.web.ecgonline.entity.dto.GenericResponse;
import com.ecg.web.ecgonline.enumerator.BrandModels;
import com.ecg.web.ecgonline.service.IBrandModelService;

@RestController
@RequestMapping("api/brand")
public class BrandModelController {

	@Autowired
	IBrandModelService brandModelService;
	
	@RequestMapping(method = RequestMethod.GET,
	            path = "/getBrandModels/{brandName}")
	public ResponseEntity<GenericResponse<List<String>>> getBrandModels(@PathVariable("brandName") String brandName,
			final HttpServletRequest request) {
		 GenericResponse<List<String>> response = new GenericResponse<List<String>>();
		 if (StringUtils.isEmpty(brandName) || BrandModels.valueFromName(brandName) == null) {
				response.setError("Enter valid brand name");
				return new ResponseEntity<GenericResponse<List<String>>>(response, HttpStatus.BAD_REQUEST);
			}
		brandName=BrandModels.valueFromName(brandName).name();
		List<String> getBrandModels = brandModelService.getBrandModels(brandName);
		response.setData(getBrandModels);
		return ResponseEntity.ok(response);
	}
	@RequestMapping(method = RequestMethod.GET,
            path = "/all")
	public ResponseEntity<GenericResponse<List<BrandModels>>> getBrandModels(final HttpServletRequest request) {
	 GenericResponse<List<BrandModels>> response = new GenericResponse<List<BrandModels>>();
	List<BrandModels> getAllBrands = brandModelService.getAllBrands();
	response.setData(getAllBrands);
	return ResponseEntity.ok(response);
	}
}
