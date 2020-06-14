package OilShopOline.web.servlet.seller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import OilShopOline.dao.SellerDao;
import OilShopOline.domain.Seller;
import OilShopOline.web.servlet.customer.LoginServlet;

/**
 * Servlet implementation class SellerLoginServlet
 */
@WebServlet("/SellerLoginServlet")
public class SellerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerLoginServlet() {
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
		String seller_name = request.getParameter("name");
		String seller_password = request.getParameter("pwd");
		String ip = LoginServlet.getRealIp(request);
		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2);
		SellerDao dao = new SellerDao();
		try {
			Seller seller = dao.SellerLogin(seller_name,seller_password);
			String seller_brand = seller.getSeller_brand();
			String seller_email = seller.getSeller_email();
			request.getSession().setAttribute("seller_name", seller_name);
			request.getSession().setAttribute("name", seller_name);
			request.getSession().setAttribute("ip", ip);
			request.getSession().setAttribute("role", "seller");
			request.getSession().setAttribute("login_time", time);
			request.getSession().setAttribute("login_date", date);
			request.getSession().setAttribute("seller_password", seller_password);
			request.getSession().setAttribute("seller_email", seller_email);
			request.getSession().setAttribute("seller_brand", seller_brand);
			request.getRequestDispatcher("/OilManageServlet").forward(request, response);
		} catch (Exception e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("SellerLogin_message", e.getMessage());
			request.getRequestDispatcher("/LogRegister/SellerLogin.jsp").forward(request, response);
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
