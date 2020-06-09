package com.example.accessingdatajpa;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
		AccountDto accountToAccountDto(Account source);
		
		Account accountDtoToAccount(AccountDto destination);

}
