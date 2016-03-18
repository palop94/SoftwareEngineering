import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistroComentDocumento extends HttpServlet {
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
 
  
          
  
	public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    
		String codigo = req.getParameter("codigo");
		String usuario = req.getParameter("usuario");
		String comentario = req.getParameter("comentario");
		
		String sql = "INSERT INTO Comentarios (Codigo, Usuario,Comentario) VALUES (";
		sql +=  "'" + codigo + "'";
		sql +=  ", '" + usuario + "'";
		sql +=  ", '" + comentario + "')";
		System.out.println("Insert sql: " + sql);
        
		try{
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Exception in RegistroComentDocumento " + e);
		}
	
    
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
			
        toClient.println("<H1>Su comentario:</H1>");
     
		toClient.println("<B><FONT size=+2>Comentario </FONT></B>");
        toClient.println("<BR><FONT size=+1><B>Codigo: </B>" + codigo + "</FONT>");
		toClient.println("<BR><FONT size=+1><B>Usuario: </B>" + usuario + "</FONT>");
		toClient.println("<P><FONT size=+1><B>Comentario: </B>" + comentario + "</FONT>");
		
		toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"InicioBusqueda\" class=\"derecha\">Busqueda &raquo;</a>");
		toClient.println("</div>");
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();    
	} 
} 
  
