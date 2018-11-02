package com.ecg.web.ecgonline.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecg.web.ecgonline.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

	User findUserByEmail(String email);

	User findUserByMobileNumberPrimary(String mobileNumberPrimary);
}
