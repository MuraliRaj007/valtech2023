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
public class OrderSummaryDAOImpl implements OrderSummaryDAO {
	
	public class OrderSummaryRowMapper implements RowMapper<OrderSummary> {
		@Override
		public OrderSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderSummary ordersummary = new OrderSummary();
			ordersummary.setId(rs.getInt(1));
			ordersummary.setProductId(rs.getInt(2));
			ordersummary.setProductQuantity(rs.getInt(3));
			return ordersummary;
		}

	}

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void createOrderSummary(OrderSummary orderSummary) {
		String createQry="INSERT INTO ORDERSUMMARY(ID,PRODUCTID,PRODUCTQUANTITY)VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,orderSummary.getId(),orderSummary.getProductId(),orderSummary.getProductQuantity());
		
	}

	@Override
	public long count() {
		String countQry = "SELECT COUNT(ID,PRODUCTID) FROM ORDERSUMMARY";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
	
	
	


	@Override
	public void deleteOrderSummary(int id, int productId) {
		String deleteQry = "DELETE FROM ORDERSUMMARY WHERE ID=? AND PRODUCTID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id , productId);		
	}

	@Override
	public void updateOrderSummary(OrderSummary orderSummary) {
		String updateQry = "UPDATE ORDERSUMMARY SET ID,PRODUCTID,PRODUCTQUANTITY WHERE ID=? AND PRODUCTID=?";
		new JdbcTemplate(dataSource).update(updateQry, orderSummary.getId(), orderSummary.getProductId(), orderSummary .getProductQuantity());		
	}

	@Override
	public List<OrderSummary> getAllOrderSummary() {
		String selectAllQry = "SELECT  ID,PRODUCTID,PRODUCTQUANTITY FROM ORDERSUMMARY";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrderSummaryRowMapper());
		}

	@Override
	public OrderSummary getOrderSummary(int id, int productId) {
		String selectQuery = "SELECT ID,PRODUCTID,PRODUCTQUANTITY FROM ORDERSUMMARY  WHERE ID=? AND PRODUCTID=? ";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new OrderSummaryRowMapper());
	}

}