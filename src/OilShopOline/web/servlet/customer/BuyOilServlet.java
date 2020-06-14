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

import OilShopOline.ComputeSimilarity;
import OilShopOline.SendBuyEmail;
import OilShopOline.service.CustomerService;

/**
 * Servlet implementation class BuyOilServlet
 */
@WebServlet("/BuyOilServlet")
public class BuyOilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyOilServlet() {
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
		String customer_name=(String) request.getSession().getAttribute("customer_name");
		String customer_email=(String) request.getSession().getAttribute("customer_email");
		String ip=(String) request.getSession().getAttribute("ip");
		String oil_id = request.getParameter("oil_id");
		String oil = request.getParameter("oil");
		String buy_number = request.getParameter("buy_number");

		LocalDate Date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date=Date.format(formatter); 
		LocalTime Time = LocalTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String time=Time.format(formatter2); 
		CustomerService service = new CustomerService();
		try {
			service.buyoil(date,time ,customer_name,oil_id,buy_number,ip);
			ComputeSimilarity cs = new ComputeSimilarity();
			cs.computeSimilarity();
			SendBuyEmail sendEmail=new SendBuyEmail();
			String str="亲爱的"+customer_name+"，您已在本店购买："+oil+" "+buy_number+"件。再次欢迎您的光临！";
			sendEmail.setReceiveMailAccount(customer_email);
			sendEmail.setInfo(str);
			sendEmail.Send();
			request.getRequestDispatcher("/ShowCartServlet").forward(request, response);
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
