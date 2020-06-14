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
 * Servlet implementation class SellerUpdateOilServlet
 */
@WebServlet("/SellerUpdateOilServlet")
public class SellerUpdateOilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerUpdateOilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=utf-8");
		request.setCharacterEncoding("UTF-8");
		String oil_id = request.getParameter("oil_id"); 
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
			service.updateOil(oil_id,oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state);
			String role= (String) request.getSession().getAttribute("role");
			String name= (String) request.getSession().getAttribute("name");
			String ip= (String) request.getSession().getAttribute("ip");
			LocalDate Date = LocalDate.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			String date=Date.format(formatter); 
			LocalTime Time = LocalTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			String time=Time.format(formatter2);
			String info = "修改商品信息，"+oil_id+"号商品【价格，余量】：【"+oil_price+","+oil_number+"】";
			MDC.put("name",name);
			MDC.put("role",role);
			MDC.put("operation_date",date);
			MDC.put("operation_time",time);
			MDC.put("ip",ip);
			MDC.put("operation_info",info);
			Logger logger = Logger.getLogger("operation_log");
			logger.info("");
			request.getRequestDispatcher("/OilManageServlet").forward(request, response);
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
