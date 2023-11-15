package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws HibernateException, ParseException {
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class);
		cfg.addAnnotatedClass(BankAccount.class);
		SessionFactory sesFac=cfg.buildSessionFactory();
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		
//		BankAccount bankAccount=new BankAccount(new BankAccountId("1", "SB"), 3000);
//		ses.persist(bankAccount);
		
		
		
//		ses.persist(new Employee("Murali", dateFormat.parse("25-01-2002"),1000000, 'M', true));
//		int id=(int) ses.save(new Employee("Murali", LocalDate.of(2002, 01, 25),1000000, 'M', true));
//		System.out.println(id);
		
//		Employee emp=(Employee) ses.get(Employee.class, 1);
//		System.out.println(emp.getClass().getName());
//		emp.setName("Murali K R");
//		emp.setActive(false);
//		
//		ses.merge(emp);
		
		Customer customer=new Customer("Murali", 22);
		ses.persist(customer);
		Address address=new Address("Royal Circle", "chintamani", "563125");
		address.setCustomer(customer);
		ses.persist(address);
		
		Customer customer1 = new Customer("Murali", 21);
		ses.persist(customer1);
		Address address1 = new Address("JP Nagar", "Bangalore", "560070");
		ses.persist(address1);
		address1.setCustomer(customer1);
		Customer customer2 = new Customer("Chandana", 22);
		ses.persist(customer2);
		Address address2 = new Address("Lingarajapuram", "Bangalore", "560084");
		ses.persist(address2);
		address2.setCustomer(customer2);
		
		Account account1=new Account(2000, "savings");
		ses.persist(account1);
		Tx  tx5=new Tx(1000);
		ses.persist(tx5);
		
		Account account=new Account(10000, "savings");
		ses.persist(account);
		Tx tx1=new Tx(1000);
		Tx tx2=new ChequeTx(2000, 123123, 321321);
		Tx tx3=new TellerTx(3000, 456456, 654654);
		Tx tx4=new AtmTx(4000, 789789);
		
		ses.persist(tx4);
		ses.persist(tx3);
		ses.persist(tx2);
		ses.persist(tx1);
		
		account.addTx(tx5);
		account.addTx(tx4);
		account.addTx(tx3);
		account.addTx(tx2);
		account.addTx(tx1);
		
		account1.addTx(tx5);
		account1.addTx(tx4);
		account1.addTx(tx3);
		account1.addTx(tx2);
		account1.addTx(tx1);
		
		account.addCustomer(customer);
		account.addCustomer(customer1);
		account1.addCustomer(customer);
		account1.addCustomer(customer2);
		
		
//		ses.createQuery("from Tx tx").list().forEach(t-> System.out.println(t));
		
//	    org.hibernate.Query query= ses.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount>?");
//	    query.setFloat(0, 2000);
//	    query.list().forEach(t -> System.out.println(t));
	    
//	    Query query=ses.createQuery("SELECT t from Tx t join t.account.customers c where c.address.city=? and t.amount>?");
//	    query.setString(0, "Bangalore");
//	    query.setFloat(1, 1000);
//	    query.list().forEach(t -> System.out.println(t));
		
//	    Query query=ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//	    query.setString(0, "chintamani");
//	    query.setFloat(1, 1000);
//	    query.list().forEach(t -> System.out.println(t));
		
		tx.commit();
		ses.close();
		sesFac.close();
	}

}
