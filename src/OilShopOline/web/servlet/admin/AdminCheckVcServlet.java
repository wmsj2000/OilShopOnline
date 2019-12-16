package OilShopOline.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminCheckVcServlet
 */
@WebServlet("/AdminCheckVcServlet")
public class AdminCheckVcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckVcServlet() {
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
		String vc = request.getParameter("vc");
		String vc2 = (String)request.getSession().getAttribute("vc");
		if(vc.equals(vc2)&&vc.length()>0&&vc2.length()>0) {
			try {
				String password = (String)request.getSession().getAttribute("password");
				request.setAttribute("pwd", password);
				request.getRequestDispatcher("/LogRegister/AdminFindBackPassword.jsp").forward(request, response);
			} catch (Exception e) {
				// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
				e.printStackTrace();
				request.setAttribute("CheckVc_message", e.getMessage());
				request.getRequestDispatcher("/LogRegister/AdminFindBackPassword.jsp").forward(request, response);
				return;
			}
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
