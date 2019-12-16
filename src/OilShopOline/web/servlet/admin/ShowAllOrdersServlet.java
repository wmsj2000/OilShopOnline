package OilShopOline.web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import OilShopOline.domain.Orders;

import OilShopOline.service.OrdersService;

/**
 * Servlet implementation class ShowAllOrdersServlet
 */
@WebServlet("/ShowAllOrdersServlet")
public class ShowAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersService service = new OrdersService();
		List<Orders> orders = null;
		try {
			orders = service.showAllOrders();
			double total_money=service.getTotalMoney();
			request.setAttribute("orders", orders);
			request.setAttribute("total_money", total_money);
			request.getRequestDispatcher("/Admin/OperationsLog.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
