package paameldingsWebapp;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logginn
 */
@WebServlet(name="loggInn", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerlisteEAO deltagerliste;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("loggedIn");
		request.getSession().removeAttribute("paamelding");
		request.getSession().removeAttribute("feilmelding");
		
		boolean feil = request.getParameter("feil") != null;
		if(feil) {
			request.getSession().setAttribute("feilmelding", "Feil passord eller mobil.");
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passord = request.getParameter("passord");
		String mobil = request.getParameter("mobil");
		try {
			DeltagerEntity d = deltagerliste.find(mobil);
			if(PassordUtil.sjekkPassord(passord, d.getPassord())) {
				request.getSession().setAttribute("eier", mobil);
				request.getSession().setAttribute("loggedIn", true);
				response.sendRedirect("deltagerliste");
			}else {
			response.sendRedirect("logginn"+"?feil");
			}
		}catch(Exception e) {
			response.sendRedirect("logginn"+"?feil");
		}
	}

}
