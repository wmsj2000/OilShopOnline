package OilShopOline.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Browse;
import OilShopOline.domain.Orders;
import OilShopOline.domain.Seller;
import OilShopOline.utils.DataSourceUtils;

public class SellerDao {
	public Seller SellerLogin(String seller_name, String seller_password) {
		try{String sql1 = "select count(*) from seller where seller_name=? and seller_password=?";
		String sql2 = "select * from seller where seller_name=? and seller_password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		long num = (long) runner.query(sql1,new ScalarHandler(),seller_name,seller_password);
		Seller seller = runner.query(sql2, new BeanHandler<Seller>(Seller.class), seller_name,seller_password);
		if(num==1) {
			return seller;
		}
		else {
			return null;
		}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SellerLogin dao ß∞‹");
	}
		
	}

	public List<Browse> showBrowseByBrand(String brand) {
		try{
		String sql1 = "select browse.browse_id,browse.browse_start_date,browse.browse_start_time,"
				+ "browse.customer_name,browse.oil_id,browse.browse_end_date,browse.browse_end_time "
				+ "from browse,oil where browse.oil_id=oil.oil_id and oil.oil_brand=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql1, new BeanListHandler<Browse>(Browse.class), brand);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("showBrowseByBrand dao ß∞‹");
	}
	}

	public List<Orders> showOrdersByBrand(String brand) {
		try{
			String sql1 = "select orders.order_id,orders.order_date,orders.order_time,orders.customer_name,orders.oil_id,orders.order_number,orders.order_abnormal_info"
					+ " from orders,oil where orders.oil_id=oil.oil_id and oil.oil_brand=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql1, new BeanListHandler<Orders>(Orders.class), brand);
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("showOrdersByBrand dao ß∞‹");
		}
	}

	public List<Orders> showAbnormalOrdersByBrand(String brand) {
		try{
			String sql1 = "select orders.order_id,orders.order_date,orders.order_time,orders.customer_name,orders.oil_id,orders.order_number,orders.order_abnormal_info"
					+ " from orders,oil where orders.oil_id=oil.oil_id and oil.oil_brand=? and orders.order_abnormal_info != '∂©µ•Œﬁ“Ï≥£' ";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql1, new BeanListHandler<Orders>(Orders.class), brand);
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("showAbnormalOrdersByBrand dao ß∞‹");
		}
	}

}
