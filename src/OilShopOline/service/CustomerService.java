package OilShopOline.service;

import OilShopOline.dao.CustomerDao;
import OilShopOline.domain.Customer;
import OilShopOline.exception.RegisterException;

public class CustomerService {
	private CustomerDao dao = new CustomerDao();
	public void Register(String customer_name, String customer_email, String customer_password) throws RegisterException {
		try {
			dao.addCustomer(customer_name,customer_email,customer_password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new OilShopOline.exception.RegisterException("ע��ʧ��");
		}
	}
	public Customer Login(String customer_name, String customer_password) throws Exception {
		// TODO Auto-generated method stub
		try {
			Customer customer = dao.Login(customer_name,customer_password);
			if(customer!=null) {return customer;}
			throw new Exception("�û������������");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("��¼ʧ��");
		}
	}
	public String getPasswordByEmail(String email) throws Exception {
		try {
			String password = dao.getPasswordByEmail(email);
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getPasswordByEmailʧ��");
		}
	}
	public int checkName(String customer_name) throws Exception {
		try {
			int s = dao.checkName(customer_name);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkNameʧ��");
		}
	}
	public int checkEmail(String customer_email) throws Exception {
		try {
			int t = dao.checkEmail(customer_email);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkEmailʧ��");
		}
	}
	public int checkCart(String customer_name, String oil_id) throws Exception {
		try {
			int t = dao.checkCart( customer_name,  oil_id);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkCartʧ��");
		}
	}
	public void addToCart(String date, String time, String customer_name, String oil_id) throws Exception {
		try {
			 dao.addToCart( date,  time,  customer_name,  oil_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("addToCartʧ��");
		}
	}
	public void buyoil(String date, String time, String customer_name, String oil_id, String buy_number, String ip) throws Exception {
		try {
			 dao.buyoil( date,  time,  customer_name,  oil_id,buy_number,ip);
			 dao.GetPortrait();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("buyoilʧ��");
		}
	}
	public void cancle(String customer_name) throws Exception {
		try {
			 dao.cancle(customer_name);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("cancleʧ��");
		}
	}

}
