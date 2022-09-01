package com.muktai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class SpringBootRestAppUnitTesting2ApplicationTests 
{
	@Autowired
	MockMvc mockMvc;
	
	@Test
	//@Disabled
	void testSaveEmp() throws Exception 
	{
		//1. create a dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.post("/person/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"rahul\",\"age\":\"21\",\"address\":\"Jalgaon\"}");
		//2.execute the request and get the ressult
		MvcResult result=mockMvc.perform(request).andReturn();
		
		//3.read the response
		MockHttpServletResponse response=result.getResponse();
		
		//4. test the response
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	
	@Test
	//@Disabled
	public void testGetAllPersons() throws Exception
	{
		//1.create dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/person/all");
		//2. Execute the request and get the result
		MvcResult result=mockMvc.perform(request).andReturn();
		//3.Read the response
		MockHttpServletResponse response=result.getResponse();
		//4. test the response status is ok 200 using asserts methods
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		if(response.getContentAsString().isEmpty())
		{
			fail("NO Person Records found!!!!");
		}
	}
	
	@Test
	//@Disabled
	public void testGetOnePerson() throws Exception
	{
		//1. create  the dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/person/one/3");
		//2. Execute that request and get the result
		MvcResult result=mockMvc.perform(request).andReturn();
		//3. read that response
		MockHttpServletResponse response=result.getResponse();
		//4. Test the response status i.e 200 
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		if(response.getContentAsString().isEmpty())
		{
			fail("Requested Person Not Found");
		}			
	}	
	
	@Test
	public void testGetOnePersonNotFound() throws Exception
	{
		//1. create  the dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/person/one/50");
		//2. Execute that request and get the result
		MvcResult result=mockMvc.perform(request).andReturn();
		//3. read that response
		MockHttpServletResponse response=result.getResponse();
		//4. Test the response status i.e 404
		assertEquals(HttpStatus.NOT_FOUND.value(),response.getStatus());		
	}	

}
