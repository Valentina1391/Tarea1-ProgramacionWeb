

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class VerCookiesServlet
 */
@WebServlet({ "/VerCookiesServlet", "/verCookies" })
public class VerCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Mis Cookies</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Cookies almacenadas</h1>");

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {

            out.println("<p>No existen cookies almacenadas.</p>");

        } else {

            String nombre = null;
            String edadTexto = null;
            String genero = null;
            String ciudad = null;
            String aceptaTexto = null;
            String correo = null;

            for (Cookie cookie : cookies) {

                switch (cookie.getName()) {

                    case "nombre":
                        nombre = cookie.getValue();
                        break;

                    case "edad":
                        edadTexto = cookie.getValue();
                        break;

                    case "genero":
                        genero = cookie.getValue();
                        break;

                    case "ciudad":
                        ciudad = cookie.getValue();
                        break;

                    case "acepta":
                        aceptaTexto = cookie.getValue();
                        break;

                    case "correo":
                        correo = cookie.getValue();
                        break;
                }
            }

            // Convertir la edad
            int edad = 0;

            if (edadTexto != null) {

                try {

                    edad = Integer.parseInt(edadTexto);

                } catch (NumberFormatException e) {

                    out.println("<p>Error: la edad almacenada no es válida.</p>");
                }
            }

            // Convertir a boolean
            boolean acepta = Boolean.parseBoolean(aceptaTexto);

            out.println("<p><strong>Nombre:</strong> "
                    + nombre + "</p>");

            out.println("<p><strong>Edad:</strong> "
                    + edad + "</p>");

            out.println("<p><strong>Género:</strong> "
                    + genero + "</p>");

            out.println("<p><strong>Ciudad:</strong> "
                    + ciudad + "</p>");

            out.println("<p><strong>Acepta términos:</strong> "
                    + acepta + "</p>");

            out.println("<p><strong>Correo:</strong> "
                    + correo + "</p>");
        }

        out.println("<br>");

        out.println("<a href='cookies.html'>Volver al formulario</a>");

        out.println("<br><br>");

        out.println("<a href='index.html'>Volver al inicio</a>");

        out.println("</body>");
        out.println("</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
