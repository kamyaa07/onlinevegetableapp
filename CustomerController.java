package com.cg.vegetable.mgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.mgmt.customer.model.Customer;
import com.cg.vegetable.mgmt.customer.repository.CustomerRepository;
import com.cg.vegetable.mgmt.exceptions.ResourceNotFoundException;
@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository custRepo;
	
	@PostMapping("/customers/newcustomer")
	public Customer createCustomer(@RequestBody Customer cust) {
	    return custRepo.save(cust);
	}
	
	@GetMapping("/customers/all")
	public List<Customer> getAllCustomers() {
	    return custRepo.findAll();
	}
	 @GetMapping("/customers/getCustomer/{cust_id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "cust_id") int CustId)
	        throws ResourceNotFoundException 
	 {
	        Customer customer = custRepo.findById(CustId)
	          .orElseThrow(() -> new ResourceNotFoundException("No Customer Found with this id : " + CustId));
	        return ResponseEntity.ok().body(customer);
	    }
	
	 
	 @PutMapping("/customers/updateCustomer/{cust_id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "cust_id") int CustId,
	         @RequestBody Customer customerDetails) throws ResourceNotFoundException {
	        Customer customer = custRepo.findById(CustId)
	        .orElseThrow(() -> new ResourceNotFoundException("No Customer Found with this Id : " + CustId));

	 

	      
			customer.setName(customerDetails.getName());
	        customer.setMobileno(customerDetails.getMobileno());
	        customer.setAddress(customerDetails.getAddress());
	        customer.setEmailid(customerDetails.getEmailid());
	        customer.setPassword(customerDetails.getPassword());
	        Customer updatedCustomer = custRepo.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
	 
	  @DeleteMapping("/customers/deleteCustomer/{cust_id}")
	    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "cust_id") int CustId)
	         throws ResourceNotFoundException {
	        Customer customer = custRepo.findById(CustId)
	       .orElseThrow(() -> new ResourceNotFoundException("No Employee Found with this Id : " + CustId));

	 

	       custRepo.delete(customer);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
 //  @DeleteMapping("/customers/deleteCustomer/{​​​​​​​cust_id}​​​​​​​")
//	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "cust_id") int  CustId)
//	         throws ResourceNotFoundException 
//	   {​​​​​​​
//	        Customer customer = custRepo.findById(cust_id)
//	       .orElseThrow(() -> new ResourceNotFoundException("No customer Found with this Id : " + CustId));
//
//
//	        custRepo.delete(customer);
//	        Map<String, Boolean> response = new HashMap<>();
//	        response.put("deleted", Boolean.TRUE);
//          return response;
 //}​​​​​​​
}
