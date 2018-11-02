package com.ecg.web.ecgonline.service;

import java.util.List;

import com.ecg.web.ecgonline.entity.GarageDetails;

public interface IGarageService {
	public String register(GarageDetails garageDetails);

	public List<GarageDetails> getAll(String query);

	public GarageDetails get(Long garageId);
}
