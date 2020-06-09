package com.example.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class CustomerDto {

  private Long id;
  private String firstName;
  private String lastName;
  
  private List<AccountDto> account = new ArrayList<AccountDto>();
  
  protected CustomerDto() {}
  public CustomerDto(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
public List<AccountDto> getAccount() {
	return account;
}
public void setAccount(List<AccountDto> account) {
	this.account = account;
}
public void setFirstName(String string) {
	this.firstName = string;
}

}