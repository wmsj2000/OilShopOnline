package OilShopOline.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.service.OilService;
/**
 * Servlet implementation class AddOilServlet
 */
@WebServlet("/AddOilServlet")
public class AddOilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOilServlet() {
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
			int t = service.CheckOil(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_state);
			if(t==0) {
			service.AddOil(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state);
			request.getRequestDispatcher("/Admin/OilManage.jsp").forward(request, response);
			}else {
				service.AddOilNumber(oil_brand,oil_category,oil_craft,oil_rank,oil_capacity,oil_price,oil_number,oil_state);
				request.getRequestDispatcher("/Admin/OilManage.jsp").forward(request, response);
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
