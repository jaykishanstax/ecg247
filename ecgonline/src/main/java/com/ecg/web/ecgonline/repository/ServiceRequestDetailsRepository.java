package com.ecg.web.ecgonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecg.web.ecgonline.entity.ServiceRequestDetails;

public interface ServiceRequestDetailsRepository extends PagingAndSortingRepository<ServiceRequestDetails, Long>, JpaSpecificationExecutor<ServiceRequestDetails> {

	List<ServiceRequestDetails> findByGarageId(Long garageId);

}

