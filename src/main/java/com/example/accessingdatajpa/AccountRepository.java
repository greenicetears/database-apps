package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

	public interface AccountRepository extends CrudRepository<Account, Long> {

	 List<Account> findByName(String name);
	
	 List<Account> findByBalanceBetween(int n, int m);
	
	 List<Account> findByNameStartingWith(String name);
	
	 List<Account> findById(long id);

	
	}

