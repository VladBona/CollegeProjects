package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItem
 * Banasko Vladyslav 99152801
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/addItem.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		String iName = request.getParameter("iname");
		String iQty = request.getParameter("iqty");
		DB_Access db = new DB_Access();
		int res = db.addItem(iName, iQty, uid);
		if (res == 0) {
			response.sendRedirect("Home?msg=Item successfully added"); 
		} else {

			response.sendRedirect("AddItem?msg=Error,try again");
		}

	
	}

}
