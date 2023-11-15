package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BankAccountId implements Serializable {

	private String accountNum;
	private String accountType;

	@Override
	public int hashCode() {
		return Objects.hash(accountNum, accountType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		return Objects.equals(accountNum, other.accountNum) && Objects.equals(accountType, other.accountType);
	}

	public BankAccountId() {
		super();
	}

	public BankAccountId(String accountNum, String accountType) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
