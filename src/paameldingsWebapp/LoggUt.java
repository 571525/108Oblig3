package paameldingsWebapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggUt
 */
@WebServlet("/loggUt")
public class LoggUt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("loggedIn");
		request.getSession().removeAttribute("eier");
		request.getSession().removeAttribute("paamelding");
		request.getRequestDispatcher("WEB-INF/ferdig.jsp").forward(request, response);
	}

}
