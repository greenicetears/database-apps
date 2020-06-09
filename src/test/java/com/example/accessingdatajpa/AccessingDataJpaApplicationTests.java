package com.example.accessingdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccessingDataJpaApplicationTests {

	@Test
	void contextLoads() {
	}

	private CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

	@Test
	public void givenSourceToDestination_whenMaps_thenCorrect() {
		CustomerDto dto = new CustomerDto();
		dto.setFirstName("test");
		List<AccountDto> accountList = new ArrayList<AccountDto>();
		AccountDto accountDto = new AccountDto("testname", 666);
		accountList.add(accountDto);
		dto.setAccount(accountList);
		Customer entity = mapper.customerDtoToCustomer(dto);
		assertEquals(dto.getAccount().get(0).getName(), entity.getAccount().get(0).getName());
		assertEquals(dto.getFirstName(), entity.getFirstName());
	}

}
