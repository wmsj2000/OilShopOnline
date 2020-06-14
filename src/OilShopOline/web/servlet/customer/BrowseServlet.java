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


/**
 * Servlet implementation class BrowseServlet
 */
@WebServlet("/BrowseServlet")
public class BrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseServlet() {
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
		String oil_id = request.getParameter("oil_id"); 
		String oil_brand = request.getParameter("oil_brand"); 
		String oil_category = request.getParameter("oil_category"); 
		String oil_craft = request.getParameter("oil_craft"); 
		String oil_rank = request.getParameter("oil_rank"); 
		String oil_capacity = request.getParameter("oil_capacity"); 
		String oil_price = request.getParameter("oil_price"); 
		String oil_number = request.getParameter("oil_number"); 
		request.setAttribute("oil_id", oil_id);
		request.setAttribute("oil_brand", oil_brand);
		request.setAttribute("oil_category", oil_category);
		request.setAttribute("oil_craft", oil_craft);
		request.setAttribute("oil_rank", oil_rank);
		request.setAttribute("oil_capacity", oil_capacity);
		request.setAttribute("oil_price", oil_price);
		request.setAttribute("oil_number", oil_number);
		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2); 
		request.getSession().setAttribute("browse_start_date", date);
		request.getSession().setAttribute("browse_start_time", time);
		request.getSession().setAttribute("browse_oil", oil_id);
		try {
			
			request.getRequestDispatcher("/Customer/OilDetail.jsp").forward(request, response);
			}
		catch (Exception e) {
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
