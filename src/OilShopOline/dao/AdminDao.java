package OilShopOline.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Admin;
import OilShopOline.domain.Performance;
import OilShopOline.domain.Portrait;
import OilShopOline.domain.Report;
import OilShopOline.domain.Seller;
import OilShopOline.utils.DataSourceUtils;


public class AdminDao {

	public Admin AdminLogin(String admin_name, String admin_password) {
		try{String sql1 = "select count(*) from admin where admin_name=? and admin_password=?";
		String sql2 = "select * from admin where admin_name=? and admin_password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		long num = (long) runner.query(sql1,new ScalarHandler(),admin_name,admin_password);
		Admin admin = runner.query(sql2, new BeanHandler<Admin>(Admin.class), admin_name,admin_password);
		if(num==1) { 
			return admin;
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
			String sql = "select admin_password from admin where admin_email=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String password = (String) runner.query(sql, new ScalarHandler(),email);
			return password;
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("getPasswordByEmail ß∞‹");
		}
	}

	public List<Seller> showSellers() {
		try{
			String sql = "select * from seller";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Seller>(Seller.class));
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("showSellers ß∞‹");
		}
	}

	public void AddSeller(String seller_name, String seller_email, String seller_password, String seller_brand) {
		try{
			String sql = "insert into seller(seller_name,seller_email,seller_password,seller_brand) values(?,?,?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,seller_name,seller_email,seller_password,seller_brand);
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("AddSeller dao ß∞‹");
		}
	}

	public void DeleteSeller(String seller_name) {
		try{
			String sql = "delete from seller where seller_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,seller_name);
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("DeleteSeller dao ß∞‹");
		}
	}

	public void ResetPwd(String seller_name) {
		try{
			String sql = "update seller set seller_password='123456' where seller_name=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql,seller_name);
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("ResetPwd dao ß∞‹");
		}
	}

	public List<Performance> showPerformance(String date1, String date2, String sname) {
		try{List<Object> list = new ArrayList<Object>();
		String sql = "select orders.order_date,orders.order_time,seller.seller_name,orders.order_id,"
				+ "oil.oil_id,oil.oil_brand,oil.oil_category,"
				+ "oil.oil_craft,oil.oil_rank,oil.oil_capacity,oil.oil_price,"
				+ "orders.order_number,orders.order_abnormal_info"
				+ " from oil,orders,seller "
				+ "where seller.seller_brand=oil.oil_brand and oil.oil_id=orders.oil_id ";
		
		if ( sname != null && sname.trim().length() > 0) {
			sql += " and seller.seller_name=?";
			list.add(sname);
		}
		if (date1 != null && date1.trim().length() > 0&&date2 != null && date2.trim().length() > 0) {
			sql += " and orders.order_date between ? and ?";
			list.add(date1);	
			list.add(date2);
		}
		
		

		Object[] params = list.toArray();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Performance>(Performance.class),
				params);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("showPerformance dao ß∞‹");
		}
	}

	public double countPerformance(String date1, String date2, String sname) {
		try{List<Object> list = new ArrayList<Object>();
		String sql = "select sum(orders.order_number*oil.oil_price)"
				+ " from oil,orders,seller "
				+ "where seller.seller_brand=oil.oil_brand and oil.oil_id=orders.oil_id ";
		
		if ( sname != null && sname.trim().length() > 0) {
			sql += " and seller.seller_name=?";
			list.add(sname);
		}
		if (date1 != null && date1.trim().length() > 0&&date2 != null && date2.trim().length() > 0) {
			sql += " and orders.order_date between ? and ?";
			list.add(date1);	
			list.add(date2);
		}
		
		

		Object[] params = list.toArray();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return (double) runner.query(sql, new ScalarHandler(),params);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("showPerformance dao ß∞‹");
		}
	}

	public List<Report> showReport(String oid, String obrand) {
		try{List<Object> list = new ArrayList<Object>();
		String sql = "select oil.oil_id,oil.oil_brand,oil.oil_category,oil.oil_state,"
				+ "oil.oil_craft,oil.oil_rank,oil.oil_capacity,oil.oil_price,"
				+ "oil.oil_number,sum(orders.order_number) as sold_number"
				+ " from oil left join orders on oil.oil_id = orders.oil_id"
				+ " where 1=1";
		
		if ( oid != null && oid.trim().length() > 0) {
			sql += " and oil.oil_id=?";
			list.add(oid);
		}
		if ( obrand != null && obrand.trim().length() > 0) {
			sql += " and oil.oil_brand=?";
			list.add(obrand);
		}
		sql=sql+" group by oil.oil_id order by oil.oil_id";

		Object[] params = list.toArray();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Report>(Report.class),
				params);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("showReport dao ß∞‹");
		}
	}

	public double countReport(String oid, String obrand) {
		try{List<Object> list = new ArrayList<Object>();
		String sql = "select sum(orders.order_number*oil.oil_price)"
				+ " from oil,orders "
				+ "where oil.oil_id=orders.oil_id ";
		
		if ( oid != null && oid.trim().length() > 0) {
			sql += " and oil.oil_id=?";
			int id = Integer.parseInt(oid);
			list.add(id);
		}
		if ( obrand != null && obrand.trim().length() > 0) {
			sql += " and oil.oil_brand=?";
			list.add(obrand);
		}
		
		Object[] params = list.toArray();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return (double) runner.query(sql, new ScalarHandler(),params);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("showReport dao ß∞‹");
		}
	}

	public List<Report> showTopOil() {
		try{
			String sql = "select oil.oil_id,oil.oil_brand,oil.oil_category,oil.oil_state,"
					+ "oil.oil_craft,oil.oil_rank,oil.oil_capacity,oil.oil_price,"
					+ "oil.oil_number,sum(orders.order_number) as sold_number"
					+ " from oil left join orders on oil.oil_id = orders.oil_id"
					+ " where order_date between current_date()-7 and sysdate() group by oil.oil_id order by sold_number desc limit 10";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Report>(Report.class));
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("showSellers ß∞‹");
		}
	}

	public List<Portrait> showPortrait(String cname) {
		try{
			String sql = "select * from portrait where 1=1";
			List<Object> list = new ArrayList<Object>();
			if ( cname != null && cname.trim().length() > 0) {
				sql += " and customer_name=?";
				list.add(cname);
			}
			Object[] params = list.toArray();
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Portrait>(Portrait.class),params);
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("showPortrait ß∞‹");
		}
	}

	public void setSimilarity(String cname, String name, double similarity) {
		try{
			String sql1 = "SELECT IFNULL((SELECT 'Y' from similarity where customer_name=? limit 1),'N')";
			String sql2 = "insert into similarity values(?,?,?);";
			String sql3 = "update similarity set similar_customer_name=?,similarity =? where customer_name=? ;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String t =(String)runner.query(sql1,new ScalarHandler(),cname);
			if(t.equals("N")) {
				runner.update(sql2,cname,name,similarity);
			}
			else {
				runner.update(sql3,name,similarity,cname);
			}
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("setSimilarity dao ß∞‹");
		}
	}

}
