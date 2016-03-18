import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class CrearCarpeta1 extends HttpServlet {
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
		
        String name = req.getParameter("Nombre");
		String proc = req.getParameter("procedente");
        String tag1 = req.getParameter("etiqueta1");
        String tag2 = req.getParameter("etiqueta2");
        String tag3 = req.getParameter("etiqueta3");
		
		//El campo procedente es necesario que ahora lo introduzca el usuario, mas tarde, cuando se desarrolle la funcion, se tomara durante el uso

        String sqlSelect = "SELECT ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas WHERE Nombre = '" +
        name + "' AND Procedente='" + proc + "'";
		System.out.println("Select sql: " + sqlSelect);
		
		String sql = "INSERT INTO Carpetas (Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3) VALUES (";
        sql +=  "'" + name + "'";
        sql +=  ", '" + proc + "'";
        sql +=  ", '" + tag1 + "'";
	    sql +=  ", '" + tag2 + "'";
        sql +=  ", '" + tag3 + "')";
        System.out.println("Insert sql: " + sql);
		
		try{
            Statement statementSelect=connection.createStatement();
            ResultSet result = statementSelect.executeQuery(sqlSelect);
            int cont;
			cont=0;
            while(result.next()) {
                
				cont=1;
				PrintWriter toClient = res.getWriter();
				toClient.println("<html>");
				toClient.println("<head><title>Folders</title></head>");
				toClient.println("<body>");
				toClient.println("<a href=\"index.html\">Home</A>");
				toClient.println("<A>This folder already exist in this site</A>");
				toClient.println("<head><title>Folders</title></head>");
				toClient.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
				toClient.println("<ul class=\"topnav\">");
				toClient.println("<li><a href=\"index.html\">TECNUN MOTORSPORT</a></li>");
				toClient.println("<li><a href=\"index.html\">Home</a></li>");
				toClient.println("<li><a href=\"busqueda.html\">Busquedas</a></li>");
				toClient.println("<li><a href=\"#contact\">Alumnos</a></li>");
				toClient.println("<li><a href=\"#about\">Coches</a></li>");
				toClient.println("<li><a href=\"MostrarCarpetas\">Carpetas</a></li>");
				toClient.println("</ul>");
		
				toClient.println("</body>");
				toClient.println("</html>");
				toClient.close();    

            }
			
            if (cont==0) {
				try{
					Statement statementInsert=connection.createStatement();
					statementInsert.executeUpdate(sql);
				
				
					PrintWriter toClient = res.getWriter();
					toClient.println("<html>");
					toClient.println("<link href=\"Micon.png\" rel=\"shortcut icon\">");
					toClient.println("<body>");
					toClient.println("<head><title>Folders</title></head>");
					toClient.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
					toClient.println("<ul class=\"topnav\">");
					toClient.println("<li><a href=\"index.html\">TECNUN MOTORSPORT</a></li>");
					toClient.println("<li><a href=\"index.html\">Home</a></li>");
					toClient.println("<li><a href=\"busqueda.html\">Busquedas</a></li>");
					toClient.println("<li><a href=\"#contact\">Alumnos</a></li>");
					toClient.println("<li><a href=\"#about\">Coches</a></li>");
					toClient.println("<li><a href=\"MostrarCarpetas\">Carpetas</a></li>");
					toClient.println("</ul>");
		
					toClient.println("<H1>The folder '" + name + "' has been created</H1>");

					toClient.println("</body>");
					toClient.println("</html>");
					toClient.close();
					
			    } catch(SQLException e) {
					e.printStackTrace();
					System.out.println("Exception in CrearCarpeta1: " + e);
				}
            }

        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Exception in CrearCarpeta1: " + e);
        }
		

}
}
