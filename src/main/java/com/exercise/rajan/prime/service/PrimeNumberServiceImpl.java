package com.exercise.rajan.prime.service;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Implementation of Service class
 */
@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	
	/**
	 * Method to calculate a list of all the prime numbers less than the 
	 * number input by the user.
	 * @param limit
	 * @return list
	 */
	@Override
	public List<Integer> getPrimes(Integer limit) {

		BitSet primes = new BitSet(limit);
		primes.set(0, false);
		primes.set(1, false);
		primes.set(2, limit, true);

		for (int p = 2; p * p <= limit; p++) {
			if (primes.get(p)) {
				for (int j = p * 2; j <= limit; j += p) {
					primes.set(j, false);
				}
			}
		}

		List<Integer> result = new LinkedList<>();
		for (int i = 0; i <= limit; i++) {
			if (primes.get(i)) {
				result.add(i);
			}
		}
		return result;
	}

}
