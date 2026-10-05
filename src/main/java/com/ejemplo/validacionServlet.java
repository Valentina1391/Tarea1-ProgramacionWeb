package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class validacionServlet
 */
@WebServlet({ "/validacionServlet", "/validacion" })
public class validacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public validacionServlet() {
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

        String nombre = request.getParameter("nombre");
        String edadTexto = request.getParameter("edad");
        String correo = request.getParameter("correo");

        // Validar nombre
        if (nombre == null || nombre.trim().isEmpty()) {
        	
            out.println("<h2>Error</h2>");
            out.println("<p>El nombre es obligatorio.</p>");
            return;
        }

        nombre = nombre.trim();

        if (nombre.length() < 2 || nombre.length() > 50) {

            out.println("<h2>Error</h2>");
            out.println("<p>El nombre debe tener entre 2 y 50 caracteres.</p>");
            return;
        }

        if (!nombre.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {

            out.println("<h2>Error</h2>");
            out.println("<p>El nombre solo puede contener letras y espacios.</p>");
            return;
        }
        
        // Validar edad
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

        // Validar rango de edad 
        if (edad < 1 || edad > 120) {

            out.println("<h2>Error</h2>");
            out.println("<p>La edad debe estar entre 1 y 120.</p>");
            return;
        }

        // Validar correo electronico
        if (correo == null || correo.trim().isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>El correo es obligatorio.</p>");
            return;
        }

        correo = correo.trim();

        if (!correo.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            out.println("<h2>Error</h2>");
            out.println("<p>El correo no tiene un formato válido.</p>");
            return;
        }
        
        // Cuando todo este correcto
        out.println("<h2>Datos recibidos correctamente</h2>");

        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Edad: " + edad + "</p>");
        out.println("<p>Correo: " + correo + "</p>");
		doGet(request, response);
	}

}
