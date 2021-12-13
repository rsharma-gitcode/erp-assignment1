package com.exercise.rajan.prime.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class PrimeNumberServiceImplTest{
	
	private PrimeNumberService primeNumberService = new PrimeNumberServiceImpl();
	
	@Test
	public void test_GetPrimeNumbersForAnInput() {
		final List<Integer>primeNumbers = primeNumberService.getPrimes(20);
		assertNotNull(primeNumbers);
		assertTrue(primeNumbers.size()>0);
	}
	
	@Test
	public void test_GetPrimeNumbersForAnInvalidInput() {
		final List<Integer>primeNumbers = primeNumberService.getPrimes(1);
		assertNotNull(primeNumbers);
		assertTrue(primeNumbers.size()==0);
	}

	
}
