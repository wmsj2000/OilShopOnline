package OilShopOline.web.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.service.CustomerService;

/**
 * Servlet implementation class CancleServlet
 */
@WebServlet("/CancleServlet")
public class CancleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancleServlet() {
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
		CustomerService service = new CustomerService();
		String customer_password = request.getParameter("customer_password");
		String customer_name=(String) request.getSession().getAttribute("customer_name");
		String customer_password2=(String) request.getSession().getAttribute("customer_password");
		PrintWriter out = response.getWriter();
		try {
			if(customer_password.equals(customer_password2)) {
				service.cancle(customer_name);
				out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('账户注销成功！');window.location.href='LogRegister/Login.jsp';</script>");
				//request.getRequestDispatcher("/LogRegeister/Login.jsp").forward(request, response);
			}
			else {
				out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('密码验证失败！');window.location.href='Customer/Information.jsp';</script>");
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
