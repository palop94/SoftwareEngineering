import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MostrarComent extends HttpServlet {
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
  
  
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		resp.setContentType("text/html");
        PrintWriter toClient = resp.getWriter();
        toClient.println("<!DOCTYPE HTML>");
        toClient.println("<html>");
		
        toClient.println("<head><link rel=\"stylesheet\" href=\"estilo.css\"><title>Comentarios</title></head>");
        toClient.println("<body>");
        
		toClient.println("<ul class=\"topnav\">");
		toClient.println("<span>&laquo; TECNUN MOTORSPORT</span>");
		toClient.println("<li><a href=Inicio.html>Home</a></li>");
		toClient.println("<li><a href=\"InicioBusqueda\">Busquedas</a></li>");
		toClient.println("<li><a href=\"UsuariosEquipo\">Alumnos</a></li>");
		toClient.println("<li><a href=\"Coche?ano=T2016\">Coches</a></li>");
		toClient.println(" <li class=\"icon\"><a href=\"javascript:void(0);\" onclick=\"myFunction()\">&#9776;</a></li>");
		toClient.println("</ul>");
			
        toClient.println("<H1>Comentarios de apoyo</H1>");
       

        toClient.println("<table border='1'>");
		
		String codigo = req.getParameter("DatosBuscar");
        String sql = "Select Codigo, Usuario, Comentario FROM Comentarios";
      
        sql += " WHERE Codigo = '" + codigo + "'";
        
        System.out.println(sql);
        
		try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
                toClient.println("<tr>");
                String codeStr = result.getString("Codigo");
                
                toClient.println("<td>" + codeStr + "</td>");
                toClient.println("<td>" + result.getString("Usuario") + "</td>");
                toClient.println("<td>" + result.getString("Comentario") + "</td>");
                toClient.println("</tr>");
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
		toClient.println("</table>");
        toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"InicioBusqueda\" class=\"derecha\">Busqueda &raquo;</a>");
		toClient.println("</div>");
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();
	}
}