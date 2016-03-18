import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Busquedas3 extends HttpServlet {
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
			
        toClient.println("<H1>BUSQUEDAS REALIZADAS</H1>");
        
        
		
        toClient.println("<table>");
        
        String sql = "Select * FROM Documento";
        String tipo = req.getParameter("tipo");
		String busqueda = req.getParameter("DatosBuscar");
		String carpeta = req.getParameter("Carpetas");
		String fechas = req.getParameter("Fechas");
		
		
		       
		
			if (tipo.equals("PorFecha")){
			sql += " WHERE Temporada like '" + fechas + "'";
		
			}
			else if (tipo.equals("PorCarpeta")){
			sql += " WHERE Carpeta like '" + carpeta + "'";
			}
			else {
			sql += " WHERE Nombre like '?" + busqueda + "?'";
			
			}
		
		
		
        System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			int num=0;
			
            while(result.next()) {
				num=num+1;
				
                toClient.println("<tr>");
				toClient.println("<tr>");
				
				
				toClient.println("<td><img src=\"Doc.png\" width=\"32\" height=\"50\" </td>");
				
                String busquedaStr = result.getString("nombre");
				
				toClient.println("<div class=Archivo>");
				toClient.println("<td>");
				if(busquedaStr != null){
				toClient.println("<td>" + busquedaStr + "</td></tr>");
				}
				else {
				toClient.println("<td> n.d. </td></tr>");	
				}
				toClient.println("</div>");
				
				
				
				toClient.println("<div class=Info>");
				toClient.println("<tr>");
				String busquedaStr2 = result.getString("temporada");
				
				if(busquedaStr2 != null){
				toClient.println("<td>&nbsp&nbsp" + busquedaStr2 + "</td>");
				}
				else {
				toClient.println("<td>  n.d. </td>");	
				}
				toClient.println("</tr>");
				
				toClient.println("<tr>");
				String busquedaStr3 = result.getString("Procedencia");
				
				if(busquedaStr3 != null){
				toClient.println("<td>&nbsp&nbsp" + busquedaStr3 + "</td>");
				}
				else {
				toClient.println("<td>  n.d. </td>");	
				}
				toClient.println("</tr>");
				
				toClient.println("<tr>");
				String busquedaStr4 = result.getString("Usuario");
				
				if(busquedaStr4 != null){
				String sql2="Select Nombre, Apellidos FROM Usuarios where ID="+ busquedaStr4 +"";
				
				try {
				Statement statement2=connection.createStatement();
				ResultSet result2 = statement2.executeQuery(sql2);
				while(result2.next()) {
					String Nombre=result2.getString("Nombre");
					String Apellidos=result2.getString("Apellidos");
					
					
				if(Nombre !=null){
				toClient.println("<td>&nbsp&nbsp" + Nombre + "");
				}
				if(Apellidos !=null){
				toClient.println("&nbsp&nbsp" + Apellidos +"</td>");
				} 
				}
				}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset:  Exception: " + e);
				}
				}
				
				else {
				String sql2="Select Nombre, Apellidos FROM Usuarios where ID="+ busquedaStr4 +"";
				toClient.println("<td>&nbsp&nbsp  n.d. </td>");	
        } 
		
		toClient.println("</div>");
		toClient.println("</tr>");
		}
		
		
		
		
		}
		catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
        toClient.println("</table>");
		
		toClient.println("<BR>");
		toClient.println("<BR>");
		toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"InicioBusqueda\" class=\"derecha\">Busqueda &raquo;</a>");
		toClient.println("</div>");
		
		/*toClient.println("<a href=\"index.html\">Home</A>");
		toClient.println("<a href=\"InicioBusqueda\">Realizar otra busqueda</A>");*/
		
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();
    }
}