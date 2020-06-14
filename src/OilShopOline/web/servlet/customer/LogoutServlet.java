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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session对象.
		String login_date= (String) request.getSession().getAttribute("login_date");
		String login_time= (String) request.getSession().getAttribute("login_time");
		String role= (String) request.getSession().getAttribute("role");
		String name= (String) request.getSession().getAttribute("name");
		String ip= (String) request.getSession().getAttribute("ip");
		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2);
		String logout_date = date;
		String logout_time = time;
		// flag标识
		String flag = request.getParameter("flag");
		if (flag == null || flag.trim().isEmpty()) {
		// 重定向到首页
		HttpSession session = request.getSession();
		// 销毁session
		session.invalidate();
		MDC.put("name",name);
		MDC.put("role",role);
		MDC.put("login_date",login_date);
		MDC.put("login_time",login_time);
		MDC.put("ip",ip);
		MDC.put("logout_date",logout_date);
		MDC.put("logout_time",logout_time);
		Logger logger = Logger.getLogger("lp_log");
		logger.info("");
		response.sendRedirect(request.getContextPath() + "/LogRegister/Login.jsp");
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
