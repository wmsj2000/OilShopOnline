package OilShopOline.web.servlet.seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SellerToUpdateServlet
 */
@WebServlet("/SellerToUpdateServlet")
public class SellerToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerToUpdateServlet() {
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
		String oil_state = request.getParameter("oil_state"); 
		request.setAttribute("oil_id", oil_id);
		request.setAttribute("oil_brand", oil_brand);
		request.setAttribute("oil_category", oil_category);
		request.setAttribute("oil_craft", oil_craft);
		request.setAttribute("oil_rank", oil_rank);
		request.setAttribute("oil_capacity", oil_capacity);
		request.setAttribute("oil_price", oil_price);
		request.setAttribute("oil_number", oil_number);
		request.setAttribute("oil_state", oil_state);
		request.getRequestDispatcher("/Seller/UpdateOil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
