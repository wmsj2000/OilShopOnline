package OilShopOline.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import OilShopOline.domain.Admin;
import OilShopOline.utils.DataSourceUtils;


public class AdminDao {

	public Admin AdminLogin(String admin_name, String admin_password) {
		try{String sql1 = "select count(*) from admin where admin_name=? and admin_password=?";
		String sql2 = "select * from admin where admin_name=? and admin_password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int num = (int) runner.query(sql1,new ScalarHandler(),admin_name,admin_password);
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

}
