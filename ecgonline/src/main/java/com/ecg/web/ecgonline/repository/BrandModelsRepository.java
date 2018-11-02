package com.ecg.web.ecgonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecg.web.ecgonline.entity.BrandModels;

public interface BrandModelsRepository extends PagingAndSortingRepository<BrandModels, Long>, JpaSpecificationExecutor<BrandModels> {
	
	@Query("select bm.brandModel from BrandModels bm where bm.brandName= ?1")
	List<String> findBrandModelByBrandName(String brandName);

}
