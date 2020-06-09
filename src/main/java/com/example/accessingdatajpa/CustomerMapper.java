package com.example.accessingdatajpa;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
	CustomerDto customerToCustomerDto(Customer source);
	
	Customer customerDtoToCustomer(CustomerDto destination);
}
