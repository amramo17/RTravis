package io.github.oliviercailloux.y2018.amramo17.javaee_servletd;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("serial")
@WebServlet("/additioner/add")
public class AdditionerServlet extends HttpServlet {

	int curlValue;

	@SuppressWarnings("unused")
	private static final Logger Log = Logger.getLogger(AdditionerServlet.class.getCanonicalName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pWriter = response.getWriter();
		response.setContentType("text/plain");
		try {
			int val1 = Integer.parseInt(request.getParameter("param1"));
			int val2 = 0;
			int addition = 0;
			if (request.getParameter("param2") == null) {
				addition = val1 + curlValue;
				pWriter.println(addition);
				Log.info(request.getParameter(curlValue + ""));
			} else {
				val2 = Integer.parseInt(request.getParameter("param2"));
				addition = val1 + val2;
				pWriter.println(val1 + val2);
				Log.info(request.getParameter("param2"));
			}

			Log.info(request.getParameter("param1"));
			Log.info(addition + "");
		} catch (Exception e) {
			pWriter.println("Exécution impossible, paramètre manquant.");
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.TEXT_PLAIN);
		response.setContentType("text/plain");

		try {
			curlValue = Integer.parseInt(request.getParameter("param2"));
			response.getWriter().println("OK");
			Log.warning("Valeur envoyé est: + " + curlValue);
		} catch (NumberFormatException e) {
			response.setStatus(400);
			response.getWriter().println("Exécution impossible, paramètre manquant.");
		}
	}
}
