package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "discriminator")
//@DiscriminatorValue("tx")
//@Table(name = "alltxs")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({@NamedQuery(name = "Tx.findAll",query = "select tx from Tx tx"),
			   @NamedQuery(name = "Tx.findAllByCityAndAmountGreaterThan",query = "select tx from Tx tx  join tx.account.customers c where c.address.city=? and amount >?")})
public class Tx {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;
	@ManyToOne(targetEntity = Account.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	private Account account;

	public Tx(float amount) {
		super();
		this.amount = amount;
	}

	public Tx() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
