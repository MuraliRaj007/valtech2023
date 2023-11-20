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
public class AddressDAOImpl implements AddressDAO {
	
	public class AddressRowMapper implements RowMapper<Address> {
		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setId(rs.getInt(1));
			address.setStreet(rs.getString(2));
			address.setCity(rs.getString(3));
			address.setZipcode(rs.getInt(4));
			
			return address;
		}

	}
	
	

	@Autowired
	private DataSource dataSource;

	@Override
	public void createAddress(Address address) {
		String createQry="INSERT INTO ADDRESS (ID,STREET,CITY,ZIPCODE)VALUES(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,address.getId(),address.getStreet(),address.getCity(),address.getZipcode());
		
	}
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(ID) FROM ADDRESS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void deleteAddress(int id) {
        String deleteQry="DELETE FROM ADDRESS WHERE ID=?";
        new JdbcTemplate(dataSource).update(deleteQry,id);
	}

	@Override
	public void updateAddress(Address address) {
		String updateQry="UPDATE ADDRESS SET STREET=?,CITY=?,ZIPCODE=?  WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry,address.getStreet(),address.getCity(),address.getZipcode(),address. getId());
	}

	@Override
	public List<Address> getAllAddress() {
		String selectAllQry="SELECT ID,STREET,CITY,ZIPCODE FROM ADDRESS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new AddressRowMapper());
	}

	@Override
	public Address getAddress(int id) {
		String selectQuery="SELECT ID,STREET,CITY,ZIPCODE FROM ADDRESS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new AddressRowMapper());
	}
	
}
