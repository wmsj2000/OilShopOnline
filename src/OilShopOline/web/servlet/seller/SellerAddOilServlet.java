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

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import OilShopOline.service.OilService;

/**
 * Servlet implementation class SellerAddOilServlet
 */
@WebServlet("/SellerAddOilServlet")
public class SellerAddOilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerAddOilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		request.setCharacterEncoding("UTF-8");
		String oil_brand = request.getParameter("oil_brand"); 
		String oil_category = request.getParameter("oil_category");
		String oil_craft = request.getParameter("oil_craft"); 
		String oil_rank = request.getParameter("oil_rank"); 
		String oil_capacity = request.getParameter("oil_capacity"); 
		String oil_price = request.getParameter("oil_price"); 
		String oil_number = request.getParameter("oil_number"); 
		String oil_state = request.getParameter("oil_state"); 
		OilService service = new OilService();
		try {
			
			String role= (String) request.getSession().getAttribute("role");
			String name= (String) request.getSession().getAttribute("name");
			String ip= (String) request.getSession().getAttribute("ip");
			LocalDate Date = LocalDate.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			String date=Date.format(formatter); 
			LocalTime Time = LocalTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			String time=Time.format(formatter2);
			String info = "增加商品，【品牌，类别，等级，容量，单价，数量，状态】：【"+oil_brand+","+oil_category+","+oil_craft+","+oil_rank+","+oil_capacity+","+oil_price+","+oil_number+","+oil_state+"】";
			MDC.put("name",name);
			MDC.put("role",role);
			MDC.put("operation_date",date);
			MDC.put("operation_time",time);
			MDC.put("ip",ip);
			MDC.put("operation_info",info);
			Logger logger = Logger.getLogger("operation_log");
			logger.info("");
			int t = service.CheckOil(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_state);
			if(t==0) {
			service.AddOil(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state);
			request.getRequestDispatcher("/OilManageServlet").forward(request, response);
			}else {
				service.AddOilNumber(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state);
				request.getRequestDispatcher("/OilManageServlet").forward(request, response);
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
