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
			throw new RuntimeException("addCustomer dao失败");
	}
}

	public Customer Login(String customer_name, String customer_password) {
		try{String sql1 = "select count(*) from customer where customer_name=? and customer_password=?";
		String sql2 = "select * from customer where customer_name=? and customer_password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		long num = (long) runner.query(sql1,new ScalarHandler(),customer_name,customer_password);
		Customer customer = runner.query(sql2, new BeanHandler<Customer>(Customer.class), customer_name,customer_password);
		if(num==1) {
			return customer;
		}
		else {
			return null;
		}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Login dao失败");
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
			throw new RuntimeException("getPasswordByEmail失败");
	}
	}

	public int checkName(String customer_name) {
		try{
			String sql = "select ifnull((select 1 from customer where customer_name=? limit 1), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			long s = (long) runner.query(sql, new ScalarHandler(),customer_name);
			if(s==1) {return 1;}
			return 0;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkName dao失败");
		}
	}

	public int checkEmail(String customer_email) {
		try{
			String sql = "select ifnull((select 1 from customer where customer_email=? limit 1), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			long s = (long) runner.query(sql, new ScalarHandler(),customer_email);
			if(s==1) {return 1;}
			return 0;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkEmail dao失败");
		}
	}

	public int checkCart(String customer_name, String oil_id) {
		try{
			String sql = "select ifnull((select 1 from cart where customer_name=? and oil_id=? limit 1), 0)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			long s = (long) runner.query(sql, new ScalarHandler(),customer_name,oil_id);
			if(s==1) {return 1;}
			return 0;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("checkName dao失败");
		}
	}

	public void addToCart(String date, String time, String customer_name, String oil_id) {
		try{
			String sql = "insert into cart(cart_date,cart_time,customer_name,oil_id) values(?,?,?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,date,time,customer_name,oil_id);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("addToCart dao失败");
		}
	}

	public void buyoil(String date, String time, String customer_name, String oil_id, String buy_number, String ip) {
		try{
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql0 = "select count(*) from orders where date(order_date) = curdate() and customer_name=?";
			long s = (long) runner.query(sql0, new ScalarHandler(),customer_name);
			String info = "";
			if(s>=10) {info="订单异常！该用户一天内下单超过10次！";}
			String sql3 = "select count(*) from (select distinct name from lp where date(login_date) = curdate() and role='customer' and ip=? )as T ";
			long t = (long) runner.query(sql3, new ScalarHandler(),ip);
			if(t>=5) {info = info + "订单异常！一天内超过5个用户登录同一ip下单！";}
			if(info=="") info="订单无异常";
			String sql = "insert into orders(order_date,order_time,customer_name,oil_id,order_number,order_abnormal_info) values(?,?,?,?,?,?)";
			String sql2 = "update oil set oil_number=oil_number-? where oil_id=?";
			
			runner.update(sql,date,time,customer_name,oil_id,buy_number,info);
			runner.update(sql2,buy_number,oil_id);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("buyoil dao失败");
		}
	}

	public void cancle(String customer_name) {
		try{
			String sql = "delete from customer where customer_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,customer_name);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("cancle dao失败");
		}
	}

	public void GetPortrait() {
		try{
			String sql1 = "truncate portrait;";
			String sql2 = "drop view cbrand;";
			String sql3 = "drop view count_brand;";
			String sql4 = "drop view ccategory;" ; 
			String sql5 = "drop view count_category;"  ;
			String sql6 = "drop view crank;" ;
			String sql7 = "drop view count_rank;";
			String sql9 = "drop view count_craft;"  ;
			String sql10 = "drop view ccraft;" ;
			String sql11= "create view cbrand as SELECT orders.customer_name,oil.oil_brand,count(oil.oil_brand) as count_brand FROM oilshop.orders left join oilshop.oil on orders.oil_id=oil.oil_id group by customer_name,oil_brand order by count_brand desc;"  ;
			String sql12= "create view count_brand as select * from (select * from cbrand order by count_brand ) as b group by customer_name;" ;
			String sql13="create view ccategory as SELECT orders.customer_name,oil.oil_category,count(oil.oil_category) as count_category FROM oilshop.orders left join oilshop.oil on orders.oil_id=oil.oil_id group by customer_name,oil_category order by count_category desc;"  ;
			String sql14="create view count_category as select * from (select * from ccategory order by count_category ) as b group by customer_name;";
			String sql15="create view crank as SELECT orders.customer_name,oil.oil_rank,count(oil.oil_rank) as count_rank FROM oilshop.orders left join oilshop.oil on orders.oil_id=oil.oil_id group by customer_name,oil_rank order by count_rank desc;"  ;
			String sql16="create view count_rank as select * from (select * from crank order by count_rank ) as b group by customer_name;" ;
			String sql17="create view ccraft as SELECT orders.customer_name,oil.oil_craft,count(oil.oil_craft) as count_craft FROM oilshop.orders left join oilshop.oil on orders.oil_id=oil.oil_id group by customer_name,oil_craft order by count_craft desc;"  ;
			String sql18="create view count_craft as select * from (select * from ccraft order by count_craft ) as b group by customer_name;";
			String sql19="insert into portrait select count_brand.customer_name,count_brand.oil_brand,count_category.oil_category,count_craft.oil_craft,count_rank.oil_rank,count_brand.count_brand,count_category.count_category,count_craft.count_craft,count_rank.count_rank from count_brand left join count_category on count_brand.customer_name=count_category.customer_name left join count_rank on count_category.customer_name=count_rank.customer_name left join count_craft on count_rank.customer_name=count_craft.customer_name;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql1);
			runner.update(sql2);
			runner.update(sql3);
			runner.update(sql4);
			runner.update(sql5);
			runner.update(sql6);
			runner.update(sql7);
			runner.update(sql9);
			runner.update(sql10);
			runner.update(sql11);
			runner.update(sql12);
			runner.update(sql13);
			runner.update(sql14);
			runner.update(sql15);
			runner.update(sql16);
			runner.update(sql17);
			runner.update(sql18);
			runner.update(sql19);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("GetPortrait dao失败");
		}
	}
}
