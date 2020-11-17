//package com.cg.vegetable.mgmt;
//
//
//
//	
//
//	import static org.mockito.Mockito.when;
//	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//	import org.junit.Test;
//	import org.junit.runner.RunWith;
//	import org.mockito.Mockito;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//	import org.springframework.boot.test.mock.mockito.MockBean;
//	import org.springframework.http.MediaType;
//	import org.springframework.test.context.junit4.SpringRunner;
//	import org.springframework.test.web.servlet.MockMvc;
//
//
//	import com.cg.vegetable.mgmt.controller.CustomerController;
//	import com.cg.vegetable.mgmt.exception.InvalidValueException;
//	import com.cg.vegetable.mgmt.customer.model.Customer;
//	import com.cg.vegetable.mgmt.service.BillingService;
//	import com.fasterxml.jackson.databind.ObjectMapper;
//
//	@RunWith(SpringRunner.class)
//	@WebMvcTest(value=BillingRestController.class)
//
//	public class TestMock{
//		@Autowired
//		private MockMvc mockMvc;
//		@MockBean
//		private BillingService service;
//		@Autowired
//		private ObjectMapper mapper;
//		@Test
//		public void TestAddBillValidInput() throws Exception
//		{
//			BillingDetails bill= new BillingDetails(3,4,"online","12-03-2020","completed");
//			when(service.addBill(bill)).thenReturn(bill);
//			mockMvc.perform(post("/add").accept(MediaType.APPLICATION_JSON)
//					.content(mapper.writeValueAsString(bill))
//					.contentType(MediaType.APPLICATION_JSON))
//			 		.andExpect(status().isOk());
//		}
//		@Test
//		public void TestAddBillInvalidInput() throws Exception
//		{
//			BillingDetails bill= new BillingDetails(3,0,null,"12-03-2020","completed");
//			when(service.addBill(Mockito.any(BillingDetails.class))).thenThrow(InvalidValueException.class);
//			mockMvc.perform(post("/add").accept(MediaType.APPLICATION_JSON)
//					.content(mapper.writeValueAsString(bill))
//					.contentType(MediaType.APPLICATION_JSON))
//					.andExpect(status().isNotFound());
//		}
//		@Test
//		public void TestUpdateBillValidInput() throws Exception
//		{
//			BillingDetails bill= new BillingDetails(6,2,"online","12-05-2020","completed");
//			when(service.updateBill(bill)).thenReturn(bill);
//			mockMvc.perform(put("/update").accept(MediaType.APPLICATION_JSON)
//					.content(mapper.writeValueAsString(bill))
//					.contentType(MediaType.APPLICATION_JSON))
//					.andExpect(status().isOk());
//		}
//		@Test
//		public void TestUpdateBillInvalidInput() throws Exception
//		{
//			BillingDetails bill= new BillingDetails(3,0,null,"12-03-2020","completed");
//			when(service.updateBill(Mockito.any(BillingDetails.class))).thenThrow(InvalidValueException.class);
//			mockMvc.perform(put("/update").accept(MediaType.APPLICATION_JSON)
//					.content(mapper.writeValueAsString(bill))
//					.contentType(MediaType.APPLICATION_JSON))
//					.andExpect(status().isNotFound());
//		}
//
//	}
