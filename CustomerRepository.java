package com.cg.vegetable.mgmt.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vegetable.mgmt.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	

}
