package com.cg.mgmt.customer.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.vegetable.mgmt.exceptions.ResourceNotFoundException;
import com.cg.vegetable.mgmt.customer.model.Customer;
import com.cg.vegetable.mgmt.customer.repository.CustomerRepository;

@Service
public class   CustomerService{
	@Autowired
	private CustomerRepository custRepo;
	
	public Customer addCustomer(Customer  customer) {
		return custRepo.save(customer);
	}
	public List<Customer> searchAllCustomers(){
		return custRepo.findAll();
	}
	
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int  custId,
		     @RequestBody Customer customerDetails) throws ResourceNotFoundException {
			Customer customer = custRepo.findById(custId)
		    .orElseThrow(() -> new ResourceNotFoundException("No customer Found with this Id : " + custId));
			customer.setName(customerDetails.getName());
			customer.setMobileno(customerDetails.getMobileno());
		    Customer updatedCustomer = custRepo.save(customer);
		    return ResponseEntity.ok(updatedCustomer);
		   }
	
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "cust_id") int  cust_Id)
		     throws ResourceNotFoundException {
		    Customer customer = custRepo.findById(cust_Id)
		   .orElseThrow(() -> new ResourceNotFoundException("No customer Found with this Id : " + cust_Id));
	        custRepo.delete(customer);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("customer deleted", Boolean.TRUE);
		    return response;
		}
	
	
}
