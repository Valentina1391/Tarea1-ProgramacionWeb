package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        if (usuario == null || usuario.trim().isEmpty()) {

            response.getWriter().println("<h2>Error</h2>");
            response.getWriter().println("<p>El usuario es obligatorio.</p>");
            return;
        }

        if (password == null || password.trim().isEmpty()) {

            response.getWriter().println("<h2>Error</h2>");
            response.getWriter().println("<p>La contraseña es obligatoria.</p>");
            return;
        }

        usuario = usuario.trim();

        if (!usuario.trim().isEmpty() && !password.trim().isEmpty()) {

            HttpSession session = request.getSession();

            request.changeSessionId();

            session.setAttribute("usuario", usuario);

            response.sendRedirect("bienvenido");

        } else {

            PrintWriter out = response.getWriter();

            out.println("<h2>Error de inicio de sesión</h2>");
            out.println("<p>El usuario y la contraseña son obligatorios.</p>");
            out.println("<br>");
            out.println("<a href='login.html'>Intentar nuevamente</a>");
        }
        
		doGet(request, response);
	}
 }
