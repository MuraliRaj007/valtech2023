package com.valtech.training.invoicespringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	

	public class CustomerRowMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPhoneNo(rs.getInt(3));
			customer.setAdderessId(rs.getInt(4));

			return customer;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createCustomer(Customer customer) {
		String createQry = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,PHONENO,ADDRESSID)VALUES(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, customer.getCustomerId(), customer.getCustomerName(),
				customer.getPhoneNo(), customer.getAdderessId());
	}

	public long count() {
		String countQry = "SELECT COUNT(CUSTOMERID) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}


	@Override
	public void deleteCustomer(int id) {
		String deleteQry = "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		String updateQry = "UPDATE CUSTOMER SET CUSTOMERID,CUSTOMERNAME,PHONENO,ADDRESSID  WHERE CUSTOMERID=?";
		new JdbcTemplate(dataSource).update(updateQry, customer.getCustomerId(), customer.getCustomerName(),
				customer.getPhoneNo(), customer.getAdderessId(), customer.getCustomerId());
	}

	@Override
	public List<Customer> getAllCustomer() {
		String selectAllQry = "SELECT CUSTOMERID,CUSTOMERNAME,PHONENO,ADDRESSID FROM CUSTOMER";
		return new JdbcTemplate(dataSource).query(selectAllQry, new CustomerRowMapper());
	}

	@Override
	public Customer getCustomer(int id) {
		String selectQuery = "SELECT  CUSTOMERID,CUSTOMERNAME,PHONENO,ADDRESSID FROM CUSTOMER WHERE CUSTOMERID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new CustomerRowMapper());
	}

}
