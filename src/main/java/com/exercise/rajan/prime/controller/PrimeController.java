package com.exercise.rajan.prime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.rajan.prime.service.PrimeNumberService;

/**
 * REST Controller which serves as an entry-point for requests for prime number information.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrimeController {

    @Autowired
    private PrimeNumberService primeNumberService;

    /**
     * API Operation that returns a list of prime numbers from 2 to the upperBound (inclusive)
     *
     * @param upperBound The inclusive upper bound to limit the size of the returned primes
     * @return a list of prime numbers from 2 to the upperBound (inclusive)
     */
   
    @GetMapping(path = "primes/{upperBound}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Integer>> primes(@PathVariable Integer upperBound) {
        return new ResponseEntity<>(primeNumberService.getPrimes(upperBound), HttpStatus.OK);
    }


}
