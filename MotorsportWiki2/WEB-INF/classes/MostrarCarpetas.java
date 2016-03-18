import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MostrarCarpetas extends HttpServlet {
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
      

        String fname = req.getParameter("fname");
        String proc = req.getParameter("proce");
		String tag = req.getParameter("tag");
	  
	  
		res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        toClient.println("<html>");
		toClient.println("<link href=\"Micon.png\" rel=\"shortcut icon\">");
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
		
        toClient.println("<body>");
        toClient.println("<h1>List of folders</h1>");
		
		toClient.println("<div class=\"CSSTableGenerator\">");
		toClient.print("<form action=\"MostrarCarpetas\" method=GET>");
		
		toClient.println("<table border='0'>");
        toClient.println("<tr>");
		toClient.println("<td><H2> Choose the filter</H2></td>");
		toClient.println("</tr>");

  	    toClient.println("<tr>");
		toClient.println("<td>Name of folder</td>");
		toClient.println("<td>  <textarea rows=\"1\" cols=\"15\" name=\"fname\"></textarea></td>");
        toClient.println("<td>Procedence</td>");
		toClient.println("<td>  <textarea rows=\"1\" cols=\"5\" name=\"proce\"></textarea></td>");
		toClient.println("<td> Tag </td>");
		toClient.println("<td>  <textarea rows=\"1\" cols=\"15\" name=\"tag\"></textarea></td>");
        toClient.println("<td> <input class=\"btn\" type=submit value= \"Apply filters\"> </td>");
		toClient.println("</tr>");
		toClient.println("</table>");
		toClient.println("</div>");
		toClient.println("</form>");
		

        toClient.println("</tr>");
		System.out.println("fname: "+ fname);
		System.out.println("fname: "+ proc);
		System.out.println("fname: "+ tag);
		 
		if (fname==null && proc==null && tag==null){
        String sql = "Select ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas";
        System.out.println(sql);
       
		try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            toClient.println("<H3> Modify de caracteristic that are available </H3>");
			
			toClient.println("<div class=\"CSSTableGenerator\">");
			toClient.print("<form action=\"ActualizarCarpeta\" method=GET>");
		
			toClient.println("<table border='1'>");
			toClient.println("<tr>");
			toClient.println("<td> ID_Folder</td>");
			toClient.println("<td>Name of folder</td>");
			toClient.println("<td>Update name</td>");
			toClient.println("<td>Procedence</td>");
			toClient.println("<td>Actual Tag 1</td>");
			toClient.println("<td>Update Tag 1 </td>");
			toClient.println("<td> ActualTag 2</td>");
			toClient.println("<td>Update Tag 2</td>");
			toClient.println("<td>Actual Tag 3</td>");
			toClient.println("<td>Update Tag 3</td>");
			toClient.println("</tr>");
				
			while(result.next()) {
				String ID =result.getString("ID");
				toClient.println("<tr>");
                toClient.println("<td>" + ID + "</td>");
				toClient.println("<td>" + result.getString("Nombre") + "</td>");
                toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"name" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Procedente") + "</td>");
				toClient.println("<td>" + result.getString("Etiqueta_1") + "</td>");
				toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag1" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Etiqueta_2") + "</td>");
				toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag2" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Etiqueta_3") + "</td>");
                toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag3" + ID + "\"></input></td>");
				toClient.println("</tr>");
            }
		toClient.println("</table>");
		toClient.println("</div>");
		toClient.println("<input class=\"btn\" type=submit value= \"Run changes\">");
        toClient.println("</form>");
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
	
		}else if (fname=="" && proc=="" && tag==""){
        String sql = "Select ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas";
        System.out.println(sql);
       
		try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            toClient.println("<H3> Modify de caracteristic that are available </H3>");
	
			toClient.println("<div class=\"CSSTableGenerator\">");
			toClient.print("<form action=\"ActualizarCarpeta\" method=GET>");
		
			toClient.println("<table border='1'>");
			toClient.println("<tr>");
			toClient.println("<td> ID_Folder</td>");
			toClient.println("<td>Name of folder</td>");
			toClient.println("<td>Update name</td>");
			toClient.println("<td>Procedence</td>");
			toClient.println("<td>Actual Tag 1</td>");
			toClient.println("<td>Update Tag 1 </td>");
			toClient.println("<td> ActualTag 2</td>");
			toClient.println("<td>Update Tag 2</td>");
			toClient.println("<td>Actual Tag 3</td>");
			toClient.println("<td>Update Tag 3</td>");
			toClient.println("</tr>");
			
			while(result.next()) {
				String ID =result.getString("ID");
				toClient.println("<tr>");
                toClient.println("<td>" + ID + "</td>");
				toClient.println("<td>" + result.getString("Nombre") + "</td>");
                toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"name" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Procedente") + "</td>");
				toClient.println("<td>" + result.getString("Etiqueta_1") + "</td>");
				toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag1" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Etiqueta_2") + "</td>");
				toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag2" + ID + "\"></input></td>");
				toClient.println("<td>" + result.getString("Etiqueta_3") + "</td>");
                toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag3" + ID + "\"></input></td>");
				toClient.println("</tr>");
            }
        toClient.println("</table>");
		toClient.println("</div>");
        toClient.println("<input class=\"btn\" type=submit value= \"Run changes\">");
		toClient.println("</form>");
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
				
		}else if (fname!=null && fname!=" " && proc=="" && tag==""){
		String sql = "SELECT ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas WHERE Nombre='" + fname  + "'" ;
        System.out.println(sql);
       
			try {
				Statement statement=connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				toClient.println("<H3> Modify de caracteristic that are available </H3>");
				
				toClient.println("<div class=\"CSSTableGenerator\">");
				toClient.print("<form action=\"ActualizarCarpeta\" method=GET>");
			
				toClient.println("<table border='1'>");
				toClient.println("<tr>");
				toClient.println("<td> ID_Folder</td>");
				toClient.println("<td>Name of folder</td>");
				toClient.println("<td>Update name</td>");
				toClient.println("<td>Procedence</td>");
				toClient.println("<td>Actual Tag 1</td>");
				toClient.println("<td>Update Tag 1 </td>");
				toClient.println("<td> ActualTag 2</td>");
				toClient.println("<td>Update Tag 2</td>");
				toClient.println("<td>Actual Tag 3</td>");
				toClient.println("<td>Update Tag 3</td>");
				toClient.println("</tr>");				
			
				while(result.next()) {
					String ID =result.getString("ID");
					toClient.println("<tr>");
					toClient.println("<td>" + ID + "</td>");
					toClient.println("<td>" + result.getString("Nombre") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"name" + ID + "\"></input></td>");
					toClient.println("<td>" + result.getString("Procedente") + "</td>");
					toClient.println("<td>" + result.getString("Etiqueta_1") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag1" + ID + "\"></input></td>");
					toClient.println("<td>" + result.getString("Etiqueta_2") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag2" + ID + "\"></input></td>");
					toClient.println("<td>" + result.getString("Etiqueta_3") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag3" + ID + "\"></input></td>");
					toClient.println("</tr>");
				}
			toClient.println("</table>");
			toClient.println("</div>");
			toClient.println("<input class=\"btn\" type=submit value= \"Run changes\">");
			toClient.println("</form>");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql + " Exception: " + e);
			}
							 
   		}else if (fname=="" && proc!=null && proc!=" " && tag==""){
		String sql1 = "SELECT ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas WHERE Procedente='" + proc  + "'" ;
        System.out.println(sql1);
       
			try {
				Statement statement=connection.createStatement();
				ResultSet result1 = statement.executeQuery(sql1);
				toClient.println("<H3> Modify de caracteristic that are available </H3>");
				
				toClient.println("<div class=\"CSSTableGenerator\">");
				toClient.print("<form action=\"ActualizarCarpeta\" method=GET>");
			
				toClient.println("<table border='1'>");
				toClient.println("<tr>");
				toClient.println("<td> ID_Folder</td>");
				toClient.println("<td>Name of folder</td>");
				toClient.println("<td>Update name</td>");
				toClient.println("<td>Procedence</td>");
				toClient.println("<td>Actual Tag 1</td>");
				toClient.println("<td>Update Tag 1 </td>");
				toClient.println("<td> ActualTag 2</td>");
				toClient.println("<td>Update Tag 2</td>");
				toClient.println("<td>Actual Tag 3</td>");
				toClient.println("<td>Update Tag 3</td>");
				toClient.println("</tr>");
			
				while(result1.next()) {
					String ID =result1.getString("ID");
					toClient.println("<tr>");
					toClient.println("<td>" + ID + "</td>");
					toClient.println("<td>" + result1.getString("Nombre") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"name" + ID + "\"></input></td>");
					toClient.println("<td>" + result1.getString("Procedente") + "</td>");
					toClient.println("<td>" + result1.getString("Etiqueta_1") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag1" + ID + "\"></input></td>");
					toClient.println("<td>" + result1.getString("Etiqueta_2") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag2" + ID + "\"></input></td>");
					toClient.println("<td>" + result1.getString("Etiqueta_3") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag3" + ID + "\"></input></td>");
					toClient.println("</tr>");
				}
			toClient.println("</table>");
			toClient.println("</div>");
			toClient.println("<input class=\"btn\" type=submit value= \"Run changes\">");
			toClient.println("</form>");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql1 + " Exception: " + e);
			}
							 
    	}else if (fname=="" && proc=="" && tag!=null && tag!=" "){
		String sql2 = "SELECT ID, Nombre, Procedente, Etiqueta_1, Etiqueta_2, Etiqueta_3 FROM Carpetas WHERE Etiqueta_1='" + tag  + "' OR Etiqueta_2= '"+ tag + "' OR Etiqueta_3='" + tag + "'" ;
        System.out.println(sql2);
       
			try {
				Statement statement=connection.createStatement();
				ResultSet result2 = statement.executeQuery(sql2);
				toClient.println("<H3> Modify de caracteristic that are available </H3>");
				
				toClient.println("<div class=\"CSSTableGenerator\">");
				toClient.print("<form action=\"ActualizarCarpeta\" method=GET>");
			
				toClient.println("<table border='1'>");
				toClient.println("<tr>");
				toClient.println("<td> ID_Folder</td>");
				toClient.println("<td>Name of folder</td>");
				toClient.println("<td>Update name</td>");
				toClient.println("<td>Procedence</td>");
				toClient.println("<td>Actual Tag 1</td>");
				toClient.println("<td>Update Tag 1 </td>");
				toClient.println("<td> ActualTag 2</td>");
				toClient.println("<td>Update Tag 2</td>");
				toClient.println("<td>Actual Tag 3</td>");
				toClient.println("<td>Update Tag 3</td>");
				toClient.println("</tr>");
			
				while(result2.next()) {
					String ID =result2.getString("ID");
					toClient.println("<tr>");
					toClient.println("<td>" + ID + "</td>");
					toClient.println("<td>" + result2.getString("Nombre") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"name" + ID + "\"></input></td>");
					toClient.println("<td>" + result2.getString("Procedente") + "</td>");
					toClient.println("<td>" + result2.getString("Etiqueta_1") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag1" + ID + "\"></input></td>");
					toClient.println("<td>" + result2.getString("Etiqueta_2") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag2" + ID + "\"></input></td>");
					toClient.println("<td>" + result2.getString("Etiqueta_3") + "</td>");
					toClient.println("<td>  <input rows=\"1\" cols=\"15\" name=\"tag3" + ID + "\"></input></td>");
					toClient.println("</tr>");
				}
			toClient.println("</table>");
			toClient.println("</div>");
			toClient.println("<input class=\"btn\" type=submit value= \"Run changes\">");
			toClient.println("</form>");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql2 + " Exception: " + e);
			}
			
        } else{
			res.getWriter().println("<h1> Please, write a unique filter </h1>" +
            "<a href='index.html'>Home</a>");
	
		}	
		toClient.println("<span class=\"izquierda\" href=\"index.html\">&laquo; Inicio</span>");
		toClient.println("<span class=\"derecha\" href=\"MostrarCarpetas\">MostrarCarpetas &raquo;</span>");
        toClient.println("</body>");
        toClient.println("</html>");
		toClient.close();
    }
	
}