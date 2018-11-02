package com.ecg.web.ecgonline.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecg.web.ecgonline.entity.GarageDetails;

public interface GarageDetailsRepository extends PagingAndSortingRepository<GarageDetails, Long>, JpaSpecificationExecutor<GarageDetails> {

}
