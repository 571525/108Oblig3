package paameldingsWebapp;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deltagerliste
 */
@WebServlet(name = "Deltagerliste", urlPatterns = "/deltagerliste")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerlisteEAO deltagerliste;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DeltagerEntity> deltagere = deltagerliste.hentAlleDeltagere();

		// Ta vare på i requesten til JSP-en
		request.getSession().setAttribute("deltagere", deltagere);
		request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
	}
}
