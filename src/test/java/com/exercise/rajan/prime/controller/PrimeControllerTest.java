package com.exercise.rajan.prime.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.exercise.rajan.prime.service.PrimeNumberService;

public class PrimeControllerTest {

	@InjectMocks
	private PrimeController primeController;

	@Mock
	private PrimeNumberService primeNumberService;

	@Autowired
	private MockMvc mvc;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(this.primeController).build();
	}

	@Test
	public void test_GetPrimeNumbersForAnInvalidInput() throws Exception {
		this.mvc.perform(
				get("/primes/1").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(content().string("[]"));

	}

}
