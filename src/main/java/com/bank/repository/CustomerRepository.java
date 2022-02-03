package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
