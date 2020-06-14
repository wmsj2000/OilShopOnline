package OilShopOline.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Orders;
import OilShopOline.utils.DataSourceUtils;

public class OrdersDao {

	public List<Orders> findAllOrders() {
		try{
			String sql = "select * from orders";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Orders>(Orders.class));

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("findAllOrders dao ß∞‹");
		}
	}

	public double getTotalMoney() {
		try{
			String sql = "select sum(orders.order_number*oil.oil_price) from oil,orders where orders.oil_id=oil.oil_id;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return (double) runner.query(sql, new ScalarHandler());

		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("getTotalMoney dao ß∞‹");
		}
	}

}
