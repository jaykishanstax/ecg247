package com.ecg.web.ecgonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ecg.web.ecgonline.entity.GarageDetails;

public interface GarageDetailsRepository extends PagingAndSortingRepository<GarageDetails, Long>, JpaSpecificationExecutor<GarageDetails> {

	@Query("SELECT g FROM GarageDetails g WHERE g.shopName LIKE :query OR " +
			"g.shopAddress LIKE :query ")
	List<GarageDetails> findAllByQuery(@Param("query") String query);

}
