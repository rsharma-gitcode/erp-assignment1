package com.exercise.rajan.prime.service;

import java.util.List;

/**
 * Service for functions related to prime-number calculation
 *
 */
public interface PrimeNumberService {

	/** Method to get a list of prime numbers less than the limit
	 * @param limit
	 * @return
	 */
	List<Integer> getPrimes(Integer limit);
}
