import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UsuariosEquipo extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:TMSwiki";
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        toClient.println("<!DOCTYPE HTML>");
        toClient.println("<html>");
		toClient.println("<center>");
        toClient.println("<head><title>Our Team</title></head>");
		toClient.println("<head><link rel=\"stylesheet\" href=\"estilo.css\"><script type=\"text/javascript\" src=\"funciones.js\"> </script><title>Busquedas realizadas</title></head>");
        toClient.println("<body>");
        
		toClient.println("<ul class=\"topnav\">");
		toClient.println("<span>&laquo; TECNUN MOTORSPORT</span>");
		toClient.println("<li><a href=Inicio.html>Home</a></li>");
		toClient.println("<li><a href=\"InicioBusqueda\">Busquedas</a></li>");
		toClient.println("<li><a href=\"UsuariosEquipo\">Alumnos</a></li>");
		toClient.println("<li><a href=\"Coche?ano=T2016\">Coches</a></li>");
		toClient.println(" <li class=\"icon\"><a href=\"javascript:void(0);\" onclick=\"myFunction()\">&#9776;</a></li>");
		toClient.println("</ul>");
		toClient.println("<center>");
        toClient.println("<a href=\"Inicio.html\">Home</A>");
        toClient.println("<h2>Team Members/Miembros del Equipo</h2>");
        toClient.println("<table border='3'>");   
        String sql = "Select nombre,apellidos,grado FROM Usuarios";
		System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                toClient.println("<tr>");
                String grad = result.getString("grado");
				toClient.println("<td>" + result.getString("nombre") + "</td>");
                toClient.println("<td>" + result.getString("apellidos") + "</td>");
                toClient.println("<td>" + grad + "</td>");
                toClient.println("</tr>");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
        toClient.println("</table>");
		toClient.println("<br>");    
		toClient.println("<br>");   
		toClient.println("<br>");   
				toClient.println("</center>");
				toClient.println("<b>");
				toClient.println("Search by/Ordenar por:                                   ");
				toClient.println("</b>");
				toClient.println("<br>");   
				toClient.println("<table border='1'>"); 
				toClient.println("<tr>");
				toClient.println("<td>" + "Name or Lastname/Nombre o apellido:");
				toClient.println("<form action=Sorted name=def>");
				toClient.println("<input name=nombre>");
				toClient.println("<input type=submit value=Send action=Sorted>");
				toClient.println("</form>");
				toClient.println( "</td>");
                toClient.println("<td>" + "Grado" );
				toClient.println("<form action=Sorted name=def>");
				toClient.println("<select name=Grado>");
				toClient.println("<option selected>Organizacion");
				toClient.println("<option>Mecanica");
				toClient.println("<option>Biomedica");
				toClient.println("<option>Tecnologias Industriales");
				toClient.println("<option>Diseno");
				toClient.println("</select>");
				toClient.println("<br>");
				toClient.println("<input type=submit value=Send action=Sorted>");
				toClient.println("</form>");
				toClient.println( "</td>");
                toClient.println("<td>" + "Vigencia");
				toClient.println("<form action=Sorted name=def>");
				toClient.println("<select name=vig>");
				toClient.println("<option selected>Si");
				toClient.println("<option>No");
				toClient.println("</select>");
				toClient.println("<br>");
				toClient.println("<input type=submit value=Send action=Sorted>");
				toClient.println("</form>");
				toClient.println( "</td>");
                toClient.println("</tr>");	
		toClient.println("<BR>");
		toClient.println("<BR>");			
				
        toClient.println("</body>");
		toClient.println("</center>");
        toClient.println("</html>");
        toClient.close();
    }
}