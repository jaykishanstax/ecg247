package com.ecg.web.ecgonline.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecg.web.ecgonline.enumerator.BrandModels;
import com.ecg.web.ecgonline.repository.BrandModelsRepository;

@Service
public class BrandModelServiceImpl implements IBrandModelService {

	@Autowired
    private BrandModelsRepository brandModelsRepository;

	@Override
	public List<String> getBrandModels(String brandName) {
		return brandModelsRepository.findBrandModelByBrandName(brandName);
	}

	@Override
	public List<BrandModels> getAllBrands() {
		return Arrays.asList(BrandModels.values());
	}
	

}
