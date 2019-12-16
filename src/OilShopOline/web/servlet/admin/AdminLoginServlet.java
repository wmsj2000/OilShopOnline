package OilShopOline.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.domain.Admin;
import OilShopOline.service.AdminService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		String admin_name = request.getParameter("name");
		String admin_password = request.getParameter("pwd");
		AdminService service = new AdminService();
		try {
			Admin admin = service.AdminLogin(admin_name,admin_password);
			String admin_email = admin.getAdmin_email();
			request.getSession().setAttribute("admin_name", admin_name);
			request.getSession().setAttribute("admin_password", admin_password);
			request.getSession().setAttribute("admin_email", admin_email);
			request.getRequestDispatcher("/FindAllOilServlet").forward(request, response);
		} catch (Exception e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("AdminLogin_message", e.getMessage());
			request.getRequestDispatcher("/LogRegister/AdminLogin.jsp").forward(request, response);
			return;
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
