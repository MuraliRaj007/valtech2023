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
public class CompanyDAOImpl implements CompanyDAO {

	public class CompanyRowMapper implements RowMapper<Company> {
		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company company = new Company();
			company.setCompanyId(rs.getInt(1));
			company.setCompanyName(rs.getString(2));
			company.setAddressId(rs.getInt(3));
			return company;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createCompany(Company company) {
		String createQry = "INSERT INTO COMPANY(COMPANYID,COMPANYNAME,ADDRESSID)VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, company.getCompanyId(), company.getCompanyName(),
				company.getAddressId());

	}

	public long count() {
		String countQry = "SELECT COUNT(COMPANYID) FROM COMPANY";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void deleteCompany(int id) {
		String deleteQry = "DELETE FROM COMPANY WHERE COMPANYID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateCompany(Company company) {
		String updateQry = "UPDATE COMPANY SET COMPANYID=?,COMPANYNAME=?,ADDRESSID=?  WHERE COMPANYID=?";
		new JdbcTemplate(dataSource).update(updateQry, company.getCompanyId(),company.getCompanyName(), company.getAddressId(),
				company.getCompanyId());
	}

	@Override
	public List<Company> getAllCompany() {
		String selectAllQry = "SELECT COMPANYID,COMPANYNAME,ADDRESSID FROM COMPANY";
		return new JdbcTemplate(dataSource).query(selectAllQry, new CompanyRowMapper());
	}

	@Override
	public Company getCompany(int id) {
		String selectQuery = "SELECT  COMPANYID,COMPANYNAME,ADDRESSID FROM COMPANY WHERE COMPANYID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new CompanyRowMapper());
	}

}
