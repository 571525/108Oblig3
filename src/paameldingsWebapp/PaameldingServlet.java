package paameldingsWebapp;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PaameldingServlet", urlPatterns = "/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Paamelding paamelding;

	@EJB
	private DeltagerlisteEAO deltagerliste;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		paamelding = new Paamelding(request);
		
		String fornavn = paamelding.getFornavn();
		String etternavn = paamelding.getEtternavn();
		String mobil = paamelding.getMobil();
		String passord = paamelding.getPassord();
		String passordRepetert = paamelding.getPassordRepetert();
		String kjonn = paamelding.getKjonn();

		if (Valider.validert(fornavn, etternavn, mobil, passord, passordRepetert, kjonn)) {
			int mobilInt = Integer.parseInt(mobil);
			String passordKryptert = PassordUtil.krypterPassord(passord);
			boolean kjonnBool = false;
			if (kjonn.equals("kvinne")) {
				kjonnBool = true;
			}
			
			request.getSession().setAttribute("paamelding", paamelding);

			try {
				deltagerliste.tilfojDeltager(fornavn, etternavn, mobilInt, passordKryptert, kjonnBool);
				request.getSession().setAttribute("eier", mobil);
				request.getSession().setAttribute("loggedIn", true);
				request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
			} catch (Exception e) {
				request.getSession().setAttribute("feilmelding", "Noe gikk galt. kanskje du allerede er tilmeldt?");
				response.sendRedirect("paamelding");
			}

		} else {
			paamelding.setFeilmeldinger();
			request.getSession().setAttribute("paamelding", paamelding);
			response.sendRedirect("paamelding");
		}

	}

}
