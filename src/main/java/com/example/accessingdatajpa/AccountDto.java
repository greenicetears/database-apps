package com.example.accessingdatajpa;
import javax.persistence.*;

public class AccountDto{

	private Long id;
	private String name;
	private int balance;
	
	protected AccountDto() {}

	 public AccountDto(String name, int bal) {
		    this.name = name;
		    this.balance = bal;
		  }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
