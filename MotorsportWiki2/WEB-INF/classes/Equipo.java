import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Equipo extends HttpServlet {
     

  public void init(ServletConfig config) throws ServletException {
  
    super.init(config);
    System.out.println("Iniciando Comements...");
  } 
        
 
  public void destroy() {
    System.out.println("No hay nada que hacer...");
  } 
  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String an= req.getParameter("ano");
               

   
    devolverPaginaHTML(resp, an);
    
  } 
    
  public void devolverPaginaHTML(HttpServletResponse resp, String an) 
      throws IOException {
   
    resp.setContentType("text/html");

  
    PrintWriter out = null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }
        
  //Se toma los datos estaticos como permanentes en la base de datos y los datos introducidos por JavaScrip se deberian escribir en la base de datos
    out.println("<HTML>");
	out.println("<center>");
    out.println("<HEAD>");
    out.println("<TITLE>Our team</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>Choose a season to see our team that season/Escoge un equipo para ver nuestro equipo esa temporada</FONT></B>");
	out.println("<br>");
	out.println("<form action=Equipo name=def>");
	
		out.println("<select name=ano>");
	out.println("<option selected>T2016");

	out.println("<option>T2015");
	out.println("<option>T2014");
	out.println("<option>T2013");
	out.println("<option>T2012");
		
    out.println("</select>");
		out.println("<br>");
	out.println("<input type=submit value=Send action=Equipo>");
	out.println("</form>");
	out.println("<script src='functions.js'>");
	out.println("</script>");
	
	out.println("<br>");
	if (an.equals("T2016")) {
		out.println("El equipo esta conformado en el el 2016 por: ");
		out.println("<br>");
		out.println("Monica Larrazabal");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
			out.println("<div id=anadir>");
		out.println("</div>");
		out.println("<form name=form1>");
      out.println("<input name=entrada>");
      out.println("<input type='button' onclick='myfunction(form1.entrada.value)' value='Add member of the team'>");
    out.println("</form>");
		
	}
		if (an.equals("T2015")) {
		out.println("El equipo esta conformado en el el 2015 por: ");
		out.println("<br>");
		out.println("Paula Lopez");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
			out.println("<div id=anadir>");
		out.println("</div>");
		out.println("<form name=form1>");
      out.println("<input name=entrada>");
      out.println("<input type='button' onclick='myfunction(form1.entrada.value)' value='Add member of the team'>");
    out.println("</form>");
		
	}
		if (an.equals("T2014")) {
		out.println("El equipo esta conformado en el el 2014 por: ");
		out.println("<br>");
		out.println("Pau Oliva");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
			out.println("<div id=anadir>");
		out.println("</div>");
		
		out.println("<form name=form1>");
      out.println("<input name=entrada>");
      out.println("<input type='button' onclick='myfunction(form1.entrada.value)' value='Add member of the team'>");
    out.println("</form>");
		
	}
		if (an.equals("T2013")) {
		out.println("El equipo esta conformado en el el 2013 por: ");
		out.println("<br>");
		out.println("No sabemos");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
			out.println("<div id=anadir>");
		out.println("</div>");
	
		out.println("<form name=form1>");
      out.println("<input name=entrada>");
      out.println("<input type='button' onclick='myfunction(form1.entrada.value)' value='Add member of the team'>");
    out.println("</form>");
		
	}
		if (an.equals("T2012")) {
		out.println("El equipo esta conformado en el el 2012 por: ");
		out.println("<br>");
		out.println("Prueba");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<br>");
		out.println(".");
		out.println("<div id=anadir>");
		out.println("</div>");
		out.println("<form name=form1>");
      out.println("<input name=entrada>");
      out.println("<input type='button' onclick='myfunction(form1.entrada.value)' value='Add member of the team'>");
    out.println("</form>");
		
	}
    out.println("<BR><a href=\"Inicio.html\">Go back to home page</a>");
    out.println("</BODY>");
	out.println("</center>");
    out.println("</HTML>");

    // Se fuerza la descarga del buffer y se cierra el PrintWriter, liberando recursos de esta forma. IMPORTANTE
    out.flush();
    out.close();
  } // fin de devolverPaginaHTML()
     
  // Función que permite al servidor web obtener una descripción del servlet:
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  } // fin del método getServletInfo()
}