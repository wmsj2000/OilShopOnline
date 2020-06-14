package OilShopOline.web.servlet.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import OilShopOline.dao.AdminDao;
import OilShopOline.domain.Performance;

/**
 * Servlet implementation class GetPerformanceServlet
 */
@WebServlet("/GetPerformanceServlet")
public class GetPerformanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPerformanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		request.setCharacterEncoding("UTF-8");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String sname = request.getParameter("sname");
		AdminDao dao = new AdminDao();
		List<Performance> performances = null;
		try {
			performances = dao.showPerformance(date1,date2,sname);
			double count = dao.countPerformance(date1,date2,sname);
			String role= (String) request.getSession().getAttribute("role");
			String name= (String) request.getSession().getAttribute("name");
			String ip= (String) request.getSession().getAttribute("ip");
			LocalDate Date = LocalDate.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			String date=Date.format(formatter); 
			LocalTime Time = LocalTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			String time=Time.format(formatter2);
			String info = "查看销售业绩，【起始时间，截止时间，销售员姓名】：【"+date1+"，"+date2+"，"+sname+"】";
			MDC.put("name",name);
			MDC.put("role",role);
			MDC.put("operation_date",date);
			MDC.put("operation_time",time);
			MDC.put("ip",ip);
			MDC.put("operation_info",info);
			Logger logger = Logger.getLogger("operation_log");
			logger.info("");
			request.setAttribute("performances", performances);
			request.setAttribute("count", count);
			request.getRequestDispatcher("/Admin/Performance.jsp").forward(request, response);
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
