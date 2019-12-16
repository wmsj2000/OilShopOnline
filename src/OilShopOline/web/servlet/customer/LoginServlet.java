package OilShopOline.web.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.domain.Customer;
import OilShopOline.service.CustomerService;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String customer_name = request.getParameter("name");
		String customer_password = request.getParameter("pwd");
		CustomerService service = new CustomerService();
		try {
			Customer customer = service.Login(customer_name,customer_password);
			String customer_email = customer.getCustomer_email();
			request.getSession().setAttribute("customer_name", customer_name);
			request.getSession().setAttribute("customer_password", customer_password);
			request.getSession().setAttribute("customer_email", customer_email);
			response.sendRedirect(request.getContextPath() + "/CustomerFindAllOilServlet");
		} catch (Exception e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("Login_message", e.getMessage());
			request.getRequestDispatcher("/LogRegister/Login.jsp").forward(request, response);
			return;
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
