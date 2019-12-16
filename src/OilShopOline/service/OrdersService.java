package OilShopOline.service;

import java.util.List;
import OilShopOline.dao.OrdersDao;
import OilShopOline.domain.Orders;

public class OrdersService {
	private OrdersDao dao = new OrdersDao();
	public List<Orders> showAllOrders() throws Exception {
		try {
			List<Orders> Orders = dao.findAllOrders();
			return Orders;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("findAllOrders ß∞‹");
		}
	}
	public double getTotalMoney() throws Exception{
		try {
			double money = dao.getTotalMoney();
			return money;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getTotalMoney ß∞‹");
		}
	}

}
