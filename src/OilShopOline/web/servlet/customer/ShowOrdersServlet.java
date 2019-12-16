package OilShopOline.web.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.domain.Oil;
import OilShopOline.domain.Orders;
import OilShopOline.service.OilService;

/**
 * Servlet implementation class ShowOrdersServlet
 */
@WebServlet("/ShowOrdersServlet")
public class ShowOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OilService service = new OilService();
		List<Oil> oils = null;
		List<Orders> orders=null;
		String customer_name=(String) request.getSession().getAttribute("customer_name");
		try {
			oils = service.findOrdersByName(customer_name);
			orders=service.findNumbersByName(customer_name);
			request.setAttribute("orders", orders);
			request.setAttribute("boughtoils", oils);
			request.getRequestDispatcher("/Customer/HistoryOrders.jsp").forward(request, response);
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
