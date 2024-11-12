package com.modulocinco.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Formulario
 */
@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;

		// Lista de arreglos de Strings, permite una estructura cerrada cada vez
		private List<String[]> contactos = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("myform.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		// Igual que en los name del formulario
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String usuario = request.getParameter("usuario");

		contactos.add(new String[] {nombre, apellido, usuario});

		// Vamos a generar la tabla con html porque su tamanio va a va variar
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		salida.println("<!DOCTYPE html>");
		salida.println("<html lang=\"es\">");
		salida.println("<head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Tabla de contactos</title>");
		salida.println("<style>body {font-family: \"Open Sans\";}</style>");
		salida.println("</head>");
		salida.println("<body>");
		salida.println("<h2>Ingresos</h2>");
		if(contactos.isEmpty()){
			salida.println("<br />");
			salida.println("<table border=1>");
			salida.println("<tr><th>Nombre</th><th>Apellido</th><th>Usuarios</th></tr>");
			
			for (String[] contacto : contactos) {
				salida.println("<tr>");
				salida.println("<td>" + contacto[0] + "</td>");
				salida.println("<td>" + contacto[1] + "</td>");
				salida.println("<td>" + contacto[2] + "</td>");
				salida.println("</tr>");
			}
		
		}
		salida.println("</table>");
		salida.println("</body>");
		salida.println("</html>");

	
	}

}
