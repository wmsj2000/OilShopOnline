package OilShopOline.web.servlet.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import OilShopOline.dao.AdminDao;

/**
 * Servlet implementation class DeleteSellerServlet
 */
@WebServlet("/DeleteSellerServlet")
public class DeleteSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSellerServlet() {
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
		String seller_name = request.getParameter("seller_name");
		AdminDao dao = new AdminDao();
		try {
			dao.DeleteSeller(seller_name);
			String role= (String) request.getSession().getAttribute("role");
			String name= (String) request.getSession().getAttribute("name");
			String ip= (String) request.getSession().getAttribute("ip");
			LocalDate Date = LocalDate.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			String date=Date.format(formatter); 
			LocalTime Time = LocalTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			String time=Time.format(formatter2);
			String info = "删除售货员，姓名【"+seller_name+"】";
			MDC.put("name",name);
			MDC.put("role",role);
			MDC.put("operation_date",date);
			MDC.put("operation_time",time);
			MDC.put("ip",ip);
			MDC.put("operation_info",info);
			Logger logger = Logger.getLogger("operation_log");
			logger.info("");
			response.sendRedirect(request.getContextPath() + "/ManageSellerServlet");
			//request.getRequestDispatcher("/Admin/OilManage.jsp").forward(request, response);
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
