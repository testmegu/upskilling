package com.example.productservice;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest(classes=ProductserviceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ProductserviceApplicationTests {
	@Autowired
	public TestRestTemplate restTemplate;

	@LocalServerPort
	public int port;

	public String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}
	@Test
	public void productybyId() {
		products product  = restTemplate.getForObject(getRootUrl() + "/allproducts/1", products.class);
		assertNotNull(product);
	}

	@Test
	public void testGetAllproducts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/allproducts",
				HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}
		@Test
		public void testDeleteproduct() {
			int id = 2;
			products product =restTemplate.getForObject(getRootUrl()+"/delete/"+id,products.class);

			assertNotNull(product);
			restTemplate.delete(getRootUrl() + "/delete/" + id);
			try {
				product = restTemplate.getForObject(getRootUrl() + "/delete/" + id, products.class);
			} catch (final HttpClientErrorException e) {
				assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
			}
		}


}
