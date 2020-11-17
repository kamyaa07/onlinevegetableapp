//package com.cg.vegetable.mgmt;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.cg.vegetable.mgmt.customer.model.Customer;
//
//@SpringBootTest(classes=OnlineVegetableAppApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class VegetableControllerTest {
//	@Autowired
//	private TestRestTemplate testRestTemplate;
//	@LocalServerPort
//	private int port;
//	
//	private String getRootUrl(){
//		return "http://localhost:"+port;
//	}
//     @Test
//	 public void testGetAllEOrders() {
//    	 HttpHeaders headers = new HttpHeaders();
//         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//         ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + "/orders/all",
//         HttpMethod.GET, entity, String.class);
//         assertNotNull(response.getBody());
//	 }
//     @Test
//     public void testGetOrderById() {
//    	 Order order = testRestTemplate.getForObject(getRootUrl() + "/orders/getorder/1", Order.class);
//         System.out.println(order.getStatus());
//         assertNotNull(order);
//     }
//     
//     @Test
//     public void testCreateOrder() {
//    	 Order order = new Order();
//    	 order.setStatus("order placed successfully");
//    	 order.setAmount(500);
//    	 order.setCustomerId(444);
//         ResponseEntity<Order> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/employees/newemployee/", order, Order.class);
//         assertNotNull(postResponse);
//         assertNotNull(postResponse.getBody());
//     }
//     
//     @Test
//     public void testUpdateOrder() {
//    	  int id = 1;
//    	  Order order = testRestTemplate.getForObject(getRootUrl() + "/orders/getOrder/" + id, Order.class);
//    	  order.setStatus("order placed successfully");
//    	  order.setAmount(6600);
//    	  order.setCustomerId(445);
//          testRestTemplate.put(getRootUrl() + "/orders/updateOrder" + id, order);
//          Order updatedOrder = testRestTemplate.getForObject(getRootUrl() + "/orders/getOrder/" + id, Order.class);
//          assertNotNull(updatedOrder);
//     }
//     
//     @Test
//     public void testDeleteOrder() {
//    	 
//    	   int id = 2;
//    	   Order order = testRestTemplate.getForObject(getRootUrl() + "/orders/getOrder/" + id, Order.class);
//           assertNotNull(order);
//           testRestTemplate.delete(getRootUrl() + "/orders/deleteOrder/" + id);
//           try {
//        	   order = testRestTemplate.getForObject(getRootUrl() + "/orders/getOrder/" + id, Order.class);
//           } catch (final HttpClientErrorException e) {
//                assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//           }
//      
//     }
//     
//
//}


package com.cg.vegetable.mgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.vegetable.mgmt.customer.model.Customer;

@SpringBootTest(classes=OnlineVegetableAppApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
 class VegetableControllerTest {
	@Autowired
	private TestRestTemplate testRestTemplate;
	@LocalServerPort
	private int port;
	
	private String getRootUrl(){
		return "http://localhost:"+port;
	}
     @Test
	  void testGetAllCustomers() {
    	 HttpHeaders headers = new HttpHeaders();
         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
         ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + "/customers/all",
         HttpMethod.GET, entity, String.class);
         assertNotNull(response.getBody());
	 }
     @Test
      void testGetCustomerById() {
    	Customer cust = testRestTemplate.getForObject(getRootUrl() + "/cust/getCustomer/1", Customer.class);
         System.out.println(cust.getName());
         assertNotNull(cust);
     }
     
     @Test
      void testCreateCustomer() {
    	 Customer cust = new Customer();
    	 cust.setName("Amisha");
    	 cust.setCustId(500);
    	 
         ResponseEntity<Customer> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/customers/newcustomer/", cust, Customer.class);
         assertNotNull(postResponse);
         assertNotNull(postResponse.getBody());
     }
     
     @Test
      void testUpdateCustomer() {
    	  int id = 1;
    	  Customer customer = testRestTemplate.getForObject(getRootUrl() + "/customers/getCustomer/" + id, Customer.class);
    	  
    	  customer.setName("Mike");
    	  customer.setCustId(445);
          testRestTemplate.put(getRootUrl() + "/customers/updateCustomer" + id, customer);
          Customer updatedCustomer = testRestTemplate.getForObject(getRootUrl() + "/customers/getCustomer/" + id, Customer.class);
          assertNotNull(updatedCustomer);
     }
     
     @Test
      void testDeleteCustomer() {
    	 
    	   int id = 2;
    	  Customer customer = testRestTemplate.getForObject(getRootUrl() + "/customers/getCustomer/" + id, Customer.class);
           assertNotNull(customer);
           testRestTemplate.delete(getRootUrl() + "/customers/deleteCustomer/" + id);
           try {
        	   customer = testRestTemplate.getForObject(getRootUrl() + "/customers/getCustomer/" + id, Customer.class);
           } catch (final HttpClientErrorException e) {
                assertEquals( HttpStatus.NOT_FOUND, e.getStatusCode());
           }
      
     }
     }

