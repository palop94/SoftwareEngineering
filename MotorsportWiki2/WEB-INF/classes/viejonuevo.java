import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Random;

@SuppressWarnings("serial")
public class viejonuevo extends HttpServlet {
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


        
        String Nombre = req.getParameter("Nombre");
        String Apellidos = req.getParameter("passviejo");
        String Grado = req.getParameter("nuevo");
		double rnd = Math.random();
		double	 rnd1 =  Math.random();
		double rnd2 =  Math.random();
		double rnd3 =  Math.random();
		String Contrasena = "def";
		String vig ="No";
		String cat = "R";
		double id1= rnd*10000 + rnd1*676*3 + rnd2*787*7 +rnd3*595*58;
		int id= (int) id1;
        String sql = "INSERT INTO Usuarios (ID, Nombre, apellidos, Contrasena, Grado, Categoria, Vigente) VALUES (";
        sql +=  "'" + id + "'";
		sql +=  ", '" + Nombre + "'";
        sql +=  ", '" + Apellidos + "'";
		sql +=  ", '" + Contrasena + "'";
		sql +=  ", '" + Grado + "'";
		sql +=  ", '" + cat + "'";
        sql +=  ", '" + vig + "')";
        System.out.println("Insert sql: " + sql);
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

         
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error en insertar un usuario nuevo: " + e);
        }

        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        toClient.println("<!DOCTYPE HTML>");
        toClient.println("<html>");
        toClient.println("<head><title>Viejo miembro del equipo anadido</title></head>");
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
        toClient.println("<a href=\"index.html\">Home</A>");
        toClient.println("<h2>Usted ha anadido al miembro:</h2>");
		toClient.println("Con el ID resultante de: " +id);
		toClient.println("<br>");
		toClient.println("Con el nombre: " + Nombre);
		toClient.println("<br>");
		toClient.println("y los apellidos: " + Apellidos);
		toClient.println("<br>");
		toClient.println("Y curso o cursa el grado de: " +Grado);
		toClient.println("<br>");
		toClient.println("<br>");
		toClient.println("<br>");
		toClient.println("<b>"+ "Nota: " + "</b>");
		toClient.println("A los miembros antiguos no se les asigna una contrasena debido a que ya no participan en el equipo, pero se les incluye para reconocer si esfuerzo en el pasado y tener datos completos de los equipos");
		toClient.println("<br>");
        toClient.println("<a href=\"UsuariosEquipo\">Miembros actuales y pasados del equipo</A>");
		toClient.println("<br>");
		toClient.println("<BR>");
		toClient.println("<BR>");
		toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"Modificacion.html\" class=\"derecha\">Modificacion &raquo;</a>");
		toClient.println("</div>");
        toClient.close();    }
}
