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
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private DataSource dataSource;

	public long count() {
		String countQry = "SELECT COUNT(PRODUCTID) FROM PRODUCT";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void createProduct(Product product) {
		String createQry = "INSERT INTO PRODUCT(PRODUCTID,PRODUCTNAME,PRODUCTAMOUNT,MANUFACTUREID)VALUES(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, product.getProductId(), product.getProductName(),
				product.productAmount, product.getManufactureId());

	}

	public class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setProductAmount(rs.getInt(3));
			product.setManufactureId(rs.getInt(4));
			return product;
		}

	}

	

	@Override
	public void deleteProduct(int productId) {
		String deleteQry = "DELETE FROM PRODUCT WHERE  PRODUCTID=?";
		new JdbcTemplate(dataSource).update(deleteQry, productId);
	}

	@Override
	public void updateProduct(Product product) {
		String updateQry = "UPDATE PRODUCT SET PRODUCTID,PRODUCTNAME,PRODUCTAMOUNT,MANUFACTUREID WHERE PRODUCTID=?";
		new JdbcTemplate(dataSource).update(updateQry, product.getProductId(), product.getProductName(),
				product.getProductAmount(), product.getManufactureId(), product.getProductId());
	}

	@Override
	public List<Product> getAllProduct() {
		String selectAllQry = "SELECT  PRODUCTID,PRODUCTNAME,PRODUCTAMOUNT,MANUFACTUREID FROM PRODUCT";
		return new JdbcTemplate(dataSource).query(selectAllQry, new ProductRowMapper());
	}

	@Override
	public Product getProduct(int productId) {
		String selectQuery = "SELECT  PRODUCTID,PRODUCTNAME,PRODUCTAMOUNT,MANUFACTUREID FROM PRODUCT  WHERE PRODUCTID=? ";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new ProductRowMapper());
	}
}
