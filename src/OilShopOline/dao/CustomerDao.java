package OilShopOline.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Customer;
import OilShopOline.utils.DataSourceUtils;




public class CustomerDao {

	public void addCustomer(String customer_name, String customer_email, String customer_password) throws SQLException {
		// TODO Auto-generated method stub
		try{String sql = "insert into customer values(?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,customer_name,customer_email,customer_password);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("addCustomer dao ß∞‹");
	}
}

	public Customer Login(String customer_name, String customer_password) {
		try{String sql1 = "select count(*) from customer where customer_name=? and customer_password=?";
		String sql2 = "select * from customer where customer_name=? and customer_password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int num = (int) runner.query(sql1,new ScalarHandler(),customer_name,customer_password);
		Customer customer = runner.query(sql2, new BeanHandler<Customer>(Customer.class), customer_name,customer_password);
		if(num==1) {
			return customer;
		}
		else {
			return null;
		}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Login dao ß∞‹");
	}
	}

	public String getPasswordByEmail(String email) {
		try{
		String sql = "select customer_password from customer where customer_email=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String password = (String) runner.query(sql, new ScalarHandler(),email);
		return password;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("getPasswordByEmail ß∞‹");
	}
	}

	public int checkName(String customer_name) {
		try{
			String sql = "select isnull((select top(1) 1 from customer where customer_name=?), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			int s = (int) runner.query(sql, new ScalarHandler(),customer_name);
			return s;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkName dao ß∞‹");
		}
	}

	public int checkEmail(String customer_email) {
		try{
			String sql = "select isnull((select top(1) 1 from customer where customer_email=?), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			int s = (int) runner.query(sql, new ScalarHandler(),customer_email);
			return s;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkEmail dao ß∞‹");
		}
	}

	public int checkCart(String customer_name, String oil_id) {
		try{
			String sql = "select isnull((select top(1) 1 from cart where customer_name=? and oil_id=?), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			int s = (int) runner.query(sql, new ScalarHandler(),customer_name,oil_id);
			return s;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkName dao ß∞‹");
		}
	}

	public void addToCart(String date, String time, String customer_name, String oil_id) {
		try{
			String sql = "insert into cart(cart_date,cart_time,customer_name,oil_id) values(?,?,?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,date,time,customer_name,oil_id);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("addToCart dao ß∞‹");
		}
	}

	public void buyoil(String date, String time, String customer_name, String oil_id, String buy_number) {
		try{
			String sql = "insert into orders(order_date,order_time,customer_name,oil_id,order_number) values(?,?,?,?,?)";
			String sql2 = "update oil set oil_number=oil_number-? where oil_id=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,date,time,customer_name,oil_id,buy_number);
			runner.update(sql2,buy_number,oil_id);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("buyoil dao ß∞‹");
		}
	}

	public void cancle(String customer_name) {
		try{
			String sql = "delete from customer where customer_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,customer_name);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("cancle dao ß∞‹");
		}
	}
}
