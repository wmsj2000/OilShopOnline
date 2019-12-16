package OilShopOline.service;

import OilShopOline.dao.AdminDao;
import OilShopOline.domain.Admin;

public class AdminService {
	private AdminDao dao = new AdminDao();

	public Admin AdminLogin(String admin_name, String admin_password) throws Exception {
		try {
			Admin admin = dao.AdminLogin(admin_name,admin_password);
			if(admin != null) {return admin;}
			throw new Exception("”√ªß√˚ªÚ√‹¬Î¥ÌŒÛ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("µ«¬º ß∞‹");
		}
	}

	public String getPasswordByEmail(String email) throws Exception {
		try {
			String password = dao.getPasswordByEmail(email);
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getPasswordByEmail ß∞‹");
		}
	}
	
}
