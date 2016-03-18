import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class InicioBusqueda extends HttpServlet {
    
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


    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	res.setContentType("text/html");
    PrintWriter toClient = res.getWriter();	
		
	toClient.println("	<HTML>");


	toClient.println("<HEAD>");
	toClient.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
	toClient.println("<TITLE>TECNUN MOTORSPORT</TITLE>");
	toClient.println("<script type=\"text/javascript\" src=\"funciones.js\"> </script>");
	toClient.println("</HEAD>");

	toClient.println("<BODY onload=\"Ocultar('formulario');Ocultar('botonBuscar'); Ocultar('textarea');Ocultar('select');Ocultar('select2')\" >");

		toClient.println("<ul class=\"topnav\">");
		toClient.println("<span>&laquo; TECNUN MOTORSPORT</span>");
		toClient.println("<li><a href=Inicio.html>Home</a></li>");
		toClient.println("<li><a href=\"InicioBusqueda\">Busquedas</a></li>");
		toClient.println("<li><a href=\"UsuariosEquipo\">Alumnos</a></li>");
		toClient.println("<li><a href=\"Coche?ano=T2016\">Coches</a></li>");
		toClient.println(" <li class=\"icon\"><a href=\"javascript:void(0);\" onclick=\"myFunction()\">&#9776;</a></li>");
		toClient.println("</ul>");
	
	
	
	
	
	toClient.println("<BR>");
	
	toClient.println("<H1 align=\"centre\"> REALICE SU BUSQUEDA </H1>");
	
	  
	
	
	
	toClient.println("<P>Seleccione tipo de busqueda   </P> ");
	
	toClient.println("<P><a class=\"btn\" type=\"button\" value=\"BUSCAR POR:\" onclick=\"Mostrar('formulario')\"  >BUSCAR POR</a></P> ");
	
	
	toClient.println("<BR>");
	
	toClient.println("<div id='formulario'> <FORM action=\"Busquedas3\" method=\"GET\"   >");
	toClient.println("<ul class=\"tab\"> ");
	toClient.println("<li><INPUT type=\"radio\" id=\"tipo\" name=\"tipo\" value=\"PorCarpeta\" id=\"PorCarpeta\" onclick=\"Mostrar('select');Mostrar('botonBuscar');bloquear('fecha');bloquear('nombre')\">POR CARPETA</li>");
	toClient.println("<li><INPUT type=\"radio\" id=\"tipo\" name=\"tipo\" value=\"PorFecha\" onclick=\"Mostrar('select2'); Mostrar('botonBuscar');bloquear('carpeta');bloquear('nombre')\">POR FECHA</li> ");			
	toClient.println("<li><INPUT type=\"radio\" id=\"tipo\" name=\"tipo\" value=\"PorNombre\" onclick=\"Mostrar('textarea'); Mostrar('botonBuscar');bloquear('carpeta');bloquear('fecha')\">POR NOMBRE</li> ");
	toClient.println("</ul>");
	toClient.println("</div >");
	
	
	toClient.println("<BR>");
	toClient.println("<div id='DatosBuscar'><TEXTAREA class= \"tabcontent\" id='textarea' name=\"DatosBuscar\" rows=\"1\" cols=\"50\" onClick=\"this.value=\"\";Mostrar('botonBuscar');Limpiar('DatosBuscar')\" >Introduzca su busqueda </TEXTAREA></div> ");

	
	toClient.println("	<div id='select' class= \"tabcontent\"> <Select name=\"Carpetas\" > ");
	String sql = "SELECT DISTINCT Nombre FROM Carpetas";
	System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
				
					String carpeta=result.getString("Nombre");
				toClient.println("	<OPTION VALUE=" + carpeta + ">&nbsp" + carpeta + "</OPTION>");
				 
				} 
				}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql + " Exception: " + e);
				}
       
		toClient.println("	</SELECT>");
		toClient.println("</div>");
		
	toClient.println("	<div id='select2' class= \"tabcontent\">	<Select name=\"Fechas\"    > ");
	String sql2 = "SELECT DISTINCT Temporada FROM Documento";
	System.out.println(sql2);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql2);
            while(result.next()) {
				
				String temporada=result.getString("Temporada");
				toClient.println("	<OPTION VALUE=" + temporada + ">&nbsp" + temporada + "</OPTION>");
				 
				} 
				}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql2 + " Exception: " + e);
				}
       
	toClient.println("	</SELECT>");
	
	toClient.println("</div>");
	
	toClient.println("	<P>");
	toClient.println("	<div id=\"botonBuscar\"><INPUT type=\"submit\" class=\"btn\"  id=\"botonBuscar\" name=\"botonBuscar\" value=\"BUSCAR\"></div>");
	toClient.println("	</P>");
	toClient.println("</font  >");
	toClient.println("</FORM>");
	
		toClient.println("<div id=\"paginacion\" class=\"paginacion\">");
		toClient.println("<a href= \"Inicio.html\" class=\"izquierda\">&laquo; Inicio</a>");
		toClient.println("<a href=\"InicioBusqueda\" class=\"derecha\">Busqueda &raquo;</a>");
		toClient.println("</div>");
		
	toClient.println("</BODY>");
	toClient.println("</HTML>");
		
	}
		
	
	}
