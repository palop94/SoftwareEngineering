import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class cambioTipo extends HttpServlet {
    Connection connection;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:TMSwiki";
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            System.out.println("Problem creating connection");
            e.printStackTrace();
        }
    }

    public void destroy () {
        super.destroy();
        System.out.print("Closing connection ...");
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch(SQLException ex){
            System.out.println("Problem closing connection");
            System.out.println(ex.getMessage());
        }
    }

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String id = req.getParameter("ID");
        String ooldPassword = req.getParameter("passviejo");
		res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        toClient.println("<!DOCTYPE HTML>");
        toClient.println("<html>");
        toClient.println("<head><title>Password</title></head>");
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
		toClient.println("<img src=http://www.luma.es/tecnun/imagenes/logo.jpg>");
		toClient.println("</center>");
		toClient.println("<br>");
		toClient.println("<br>");
		toClient.println("You sucefully changed this user category/Has cambiado la category de este usuario");
		toClient.println("<BR>");
		toClient.println("<BR>");
		toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"Modificacion.html\" class=\"derecha\">Modificacion &raquo;</a>");
		toClient.println("</div>");
 
        if(ooldPassword==null) {
        System.out.println("Introduce a new category");
          return;
        }
		  if(id==null) {
         System.out.println("Introduce the id of the user that you want to change");
          return;
        }

        Statement stmt = null;
        try {
            stmt=connection.createStatement();
            ResultSet rs = null;
			String sql = "UPDATE Usuarios SET Categoria = '" + ooldPassword + "' WHERE ID like '" + id + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
			
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            return;
        } finally {      
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch(SQLException e) {
                    System.out.println("Error closing Statement");
                    System.out.println(e.getMessage());
                    return;
                }
            }
        } 
    
	

		
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close(); 

	
	
	} 


}