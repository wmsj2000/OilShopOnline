package OilShopOline.web.servlet.customer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public static String getRealIp(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("X-FORWARDED-FOR ");
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr ();
            }
            if (ip != null && ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        } catch (Throwable e) {
 
        }
        return ip;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String ip = LoginServlet.getRealIp(request);
		String customer_name = request.getParameter("name");
		String customer_password = request.getParameter("pwd");
		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2);
		CustomerService service = new CustomerService();
		try {
			Customer customer = service.Login(customer_name,customer_password);
			String customer_email = customer.getCustomer_email();
			request.getSession().setAttribute("customer_name", customer_name);
			request.getSession().setAttribute("customer_password", customer_password);
			request.getSession().setAttribute("customer_email", customer_email);
			request.getSession().setAttribute("role", "customer");
			request.getSession().setAttribute("name", customer_name);
			request.getSession().setAttribute("login_date", date);
			request.getSession().setAttribute("login_time", time);
			request.getSession().setAttribute("ip", ip);
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
