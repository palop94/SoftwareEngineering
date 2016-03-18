import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class saveDocument extends HttpServlet {
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
        toClient.println("<head><link rel=\"stylesheet\" href=\"estilo.css\"><script type=\"text/javascript\" src=\"funciones.js\"> </script><title>Documento</title></head>");
        toClient.println("<body>");
		
		
        String Nombre = req.getParameter("title");
        String Temporada = req.getParameter("season");
        String CampoAuxiliar = req.getParameter("auxiliar");
		String Carpeta = req.getParameter("folder");
		String Procedencia = req.getParameter("precedent");
		String Usuario = req.getParameter("author");
        String sql = "INSERT INTO Documento (Nombre, Temporada, CampoAuxiliar, Carpeta, Procedencia, Usuario) VALUES (";
        sql +=  "'" + Nombre + "'";
        sql +=  ", '" + Temporada + "'";
		sql +=  ", '" + CampoAuxiliar + "'";
        sql +=  ", '" + Carpeta + "'";
		sql +=  ", '" + Procedencia + "'";
		sql +=  ", '" + Usuario + "')";
        System.out.println("Insert sql: " + sql);
		
		try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

         
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error en subir el documento: " + e);
        }
		
        
        //toClient.println("<!DOCTYPE HTML>");
        //toClient.println("<html>");
        //toClient.println("<head><title>Documents</title></head>");
        //toClient.println("<body>");
        toClient.println("<a href=\"index.html\">Home</a>");
        toClient.println("<h2>Your document has been uploaded to the Wiki</h2>");
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();    
	}
}