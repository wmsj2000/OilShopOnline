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

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import OilShopOline.service.CustomerService;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		String customer_name=(String) request.getSession().getAttribute("customer_name");
		String browse_start_date=(String) request.getSession().getAttribute("browse_start_date");
		String browse_start_time=(String) request.getSession().getAttribute("browse_start_time");
		String oil_id = request.getParameter("oil_id");
		int id = Integer.parseInt(oil_id);
		CustomerService service = new CustomerService();
		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2); 
		int t;
		try {
			MDC.put("browse_start_date",browse_start_date);
			MDC.put("browse_start_time",browse_start_time);
			MDC.put("browse_end_date",date);
			MDC.put("browse_end_time",time);
			MDC.put("customer_name",customer_name);
			MDC.put("oil_id",id);
			Logger logger = Logger.getLogger("browse_log");
			logger.info("");
			t = service.checkCart(customer_name,oil_id);
			if(t==1) {
				request.getRequestDispatcher("/CustomerFindAllOilServlet").forward(request, response);
			}else {
			service.addToCart(date,time ,customer_name,oil_id);
			request.getRequestDispatcher("/CustomerFindAllOilServlet").forward(request, response);
			}
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
