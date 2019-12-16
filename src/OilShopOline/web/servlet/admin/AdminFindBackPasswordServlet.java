package OilShopOline.web.servlet.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.SendEmail;
import OilShopOline.service.AdminService;


/**
 * Servlet implementation class AdminFindBackPasswordServlet
 */
@WebServlet("/AdminFindBackPasswordServlet")
public class AdminFindBackPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFindBackPasswordServlet() {
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
		String email = request.getParameter("email");
		SendEmail sendEmail=new SendEmail();
		//设置要发送的邮箱
		sendEmail.setReceiveMailAccount(email);
		//创建6位发验证码
		Random random=new Random();
		String str="";
		for(int i=0;i<6;i++) {
			int n=random.nextInt(10);
			str+=n;
		}
		request.getSession().setAttribute("vc", str);
		sendEmail.setInfo(str);
		try {
			sendEmail.Send();
			AdminService service = new AdminService();
			String password = service.getPasswordByEmail(email);
			request.getSession().setAttribute("password",password);
			request.getRequestDispatcher("/LogRegister/AdminFindBackPassword.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("FBDP_message", e.getMessage());
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
