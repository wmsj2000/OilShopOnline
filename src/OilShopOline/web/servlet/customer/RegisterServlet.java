package OilShopOline.web.servlet.customer;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OilShopOline.exception.RegisterException;
import OilShopOline.service.CustomerService;




/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String customer_name = request.getParameter("name");
		String customer_email = request.getParameter("email");
		String customer_password = request.getParameter("pwd");
		CustomerService service = new CustomerService();
		PrintWriter out = response.getWriter();
		try {
			int s = service.checkName(customer_name);
			int t = service.checkEmail(customer_email);
			if(s==1&&t==0) {
				out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('此用户名已被注册！注册失败!');window.location.href='LogRegister/Register.jsp';</script>");
			}
			else if(t==1&&s==0) {
				out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('此邮箱已被注册！注册失败!');window.location.href='LogRegister/Register.jsp';</script>");
			}
			else if(t==1&&s==1) {
				out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('此用户名已被注册！此邮箱已被注册！注册失败!');window.location.href='LogRegister/Register.jsp';</script>");
			}
			else{
			service.Register(customer_name, customer_email,customer_password);
			out.print("<script language=\"javascript\" type=\"text/javascript\" charset = \"UTF-8\">alert('注册成功!');window.location.href='LogRegister/RegisterSuccess.jsp';</script>");
			//request.getRequestDispatcher("/LogRegister/RegisterSuccess.jsp").forward(request, response);
			}
			
		} catch (RegisterException e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			//request.getRequestDispatcher("/LogRegister/Register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("register2_message", e.getMessage());
			//request.getRequestDispatcher("/LogRegister/Register.jsp").forward(request, response);
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
