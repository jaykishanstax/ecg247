package com.ecg.web.ecgonline.service;

import java.util.List;

import com.ecg.web.ecgonline.enumerator.BrandModels;

public interface IBrandModelService {
	public List<String> getBrandModels(String brandName);
	public List<BrandModels> getAllBrands();
}
