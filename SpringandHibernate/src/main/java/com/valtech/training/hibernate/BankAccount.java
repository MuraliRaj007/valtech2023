package com.valtech.training.hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BankAccount {
	
	@EmbeddedId
	private BankAccountId Id;
	private double balance;
	
	
	public BankAccount() {
		super();
	}
	public BankAccount(BankAccountId id, double balance) {
		super();
		Id = id;
		this.balance = balance;
	}
	public BankAccountId getId() {
		return Id;
	}
	public void setId(BankAccountId id) {
		Id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
