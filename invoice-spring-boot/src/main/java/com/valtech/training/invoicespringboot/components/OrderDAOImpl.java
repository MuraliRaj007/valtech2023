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
public class OrderDAOImpl implements OrdersDAO {

	public class OrdersRowMapper implements RowMapper<Orders> {
		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders orders = new Orders();
			orders.setId(rs.getInt(1));
			orders.setOrderDate(rs.getDate(2));
			orders.setCustomerId(rs.getInt(3));
			return orders;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createOrders(Orders order) {
		String createQry = "INSERT INTO ORDERS(ID,ORDERDATE,CUSTOMERID)VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, order.getId(), order.getOrderDate(), order.getCustomerId());

	}

	@Override
	public long count() {
		String countQry = "SELECT COUNT(ID) FROM ORDERS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void deleteOrders(int id) {
		String deleteQry = "DELETE FROM ORDERS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateOrders(Orders orders) {
		String updateQry = "UPDATE ORDERS SET ID,ORDERDATE,CUSTOMERID WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry, orders.getId(), orders.getOrderDate(), orders.getCustomerId());
	}

	@Override
	public List<Orders> getAllOrders() {
		String selectAllQry = "SELECT  ID,ORDERDATE,CUSTOMERID  FROM ORDERS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrdersRowMapper());
	}

	

	@Override
	public Orders getOrder(int id) {
		String selectQuery = "SELECT ID,ORDERDATE,CUSTOMERID  FROM ORDERS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQuery, new OrdersRowMapper());	}

}
