package OilShopOline.web.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import OilShopOline.dao.AdminDao;
import OilShopOline.dao.OilDao;
import OilShopOline.domain.Oil;
import OilShopOline.domain.Report;

/**
 * Servlet implementation class RecommendationServlet
 */
@WebServlet("/RecommendationServlet")
public class RecommendationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OilDao dao = new OilDao();
		AdminDao adao = new AdminDao();
		List<Oil> oils = null;
		List<Report> reports = null;
		String customer_name=(String) request.getSession().getAttribute("customer_name");
		try {
			oils = dao.recommend(customer_name);
			reports=adao.showTopOil();
			if(oils==null) request.setAttribute("recommendations", reports);
			else request.setAttribute("recommendations", oils);
			request.getRequestDispatcher("/Customer/Recommendation.jsp").forward(request, response);
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
