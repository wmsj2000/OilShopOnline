package OilShopOline.web.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.domain.Oil;
import OilShopOline.service.OilService;

/**
 * Servlet implementation class SummaryServlet
 */
@WebServlet("/SummaryServlet")
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OilService service = new OilService();
		List<Oil> oils = null;
		List<Integer> sold_numbers = new ArrayList<Integer>();
		int total_money=0;
		try {
			oils = service.findOils();
			//sold_numbers=service.findNumbers();
			total_money=service.getTotalMoney();
			request.setAttribute("sold_numbers", sold_numbers);
			request.setAttribute("oils", oils);
			request.setAttribute("total_money", total_money);
			request.getRequestDispatcher("/Admin/Summary.jsp").forward(request, response);
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
