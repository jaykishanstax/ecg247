package com.ecg.web.ecgonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecg.web.ecgonline.entity.GarageDetails;
import com.ecg.web.ecgonline.repository.GarageDetailsRepository;

@Service
public class GarageServiceImpl implements IGarageService {

	@Autowired
    private GarageDetailsRepository garageDetailsRepository;
	
	@Override
	public String register(GarageDetails garageDetails) {
		garageDetailsRepository.save(garageDetails);
		return "Garage Registered successfully";
	}

}
