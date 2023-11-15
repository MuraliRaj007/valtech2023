package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atmtx")
public class AtmTx extends Tx {
	
	private int atm;

	public AtmTx(float amount, int atm) {
		super(amount);
		this.atm = atm;
	}

	public AtmTx() {
		super();
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
