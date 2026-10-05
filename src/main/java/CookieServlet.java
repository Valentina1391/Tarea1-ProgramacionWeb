

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet({ "/CookieServlet", "/cookies" })
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//Recibir datos
		String nombre = request.getParameter("nombre");

        String edadTexto = request.getParameter("edad");

        String genero = request.getParameter("genero");

        String ciudad = request.getParameter("ciudad");

        String correo = request.getParameter("correo");

        String aceptaTexto = request.getParameter("acepta");
        
        //Validar datos
        if (nombre == null || nombre.trim().isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>El nombre es obligatorio.</p>");
            return;
        }


        if (edadTexto == null || edadTexto.trim().isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>La edad es obligatoria.</p>");
            return;
        }


        int edad;

        try {

            edad = Integer.parseInt(edadTexto);

        } catch (NumberFormatException e) {

            out.println("<h2>Error</h2>");
            out.println("<p>La edad debe ser un número.</p>");
            return;
        }


        if (edad < 1 || edad > 120) {

            out.println("<h2>Error</h2>");
            out.println("<p>La edad debe estar entre 1 y 120.</p>");
            return;
        }


        if (genero == null || genero.isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>Debe seleccionar un género.</p>");
            return;
        }


        if (ciudad == null || ciudad.isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>Debe seleccionar una ciudad.</p>");
            return;
        }


        if (correo == null || correo.trim().isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>El correo es obligatorio.</p>");
            return;
        }
        
        //Convertir boolean
        boolean acepta = "true".equals(aceptaTexto);
        
        //Crear cookies
        Cookie cookieNombre =
                new Cookie("nombre", nombre);

        Cookie cookieEdad =
                new Cookie("edad", String.valueOf(edad));

        Cookie cookieGenero =
                new Cookie("genero", genero);

        Cookie cookieCiudad =
                new Cookie("ciudad", ciudad);

        Cookie cookieAcepta =
                new Cookie("acepta", String.valueOf(acepta));

        Cookie cookieCorreo =
                new Cookie("correo", correo);
        
        response.addCookie(cookieNombre);

        response.addCookie(cookieEdad);

        response.addCookie(cookieGenero);

        response.addCookie(cookieCiudad);

        response.addCookie(cookieAcepta);

        response.addCookie(cookieCorreo);
        
        //Resultados
        out.println("<h1>Cookies guardadas correctamente</h1>");

        out.println("<p>Nombre: " + nombre + "</p>");

        out.println("<p>Edad: " + edad + "</p>");

        out.println("<p>Género: " + genero + "</p>");

        out.println("<p>Ciudad: " + ciudad + "</p>");

        out.println("<p>Acepta términos: " + acepta + "</p>");

        out.println("<p>Correo: " + correo + "</p>");

        out.println("<br>");

        out.println("<a href='index.html'>Volver al inicio</a>");
        
		doGet(request, response);
	}

}
