import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Coche extends HttpServlet {
     

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
        
 
    out.println("<HTML>");
	out.println("<center>");
    out.println("<HEAD>");
    out.println("<TITLE>Cars</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>Cars from old seasons/Coches de temporadas pasadas</FONT></B>");
	out.println("<br>");
	out.println("<form action=Coche	name=def>");
	
		out.println("<select name=ano>");
	out.println("<option selected>T2014");

	out.println("<option>T2013");
	out.println("<option>T2012");
	out.println("<option>T2011");
	out.println("<option>T2010");
		
    out.println("</select>");
		out.println("<br>");
	out.println("<input type=submit value=Send action=Coche>");
	out.println("</form>");
	out.println("<script src='functions.js'>");
	out.println("</script>");
	
	out.println("<br>");
	out.println("You can pass your mouse over to expand the image!");
	out.println("<br>");	
	out.println("<br>");
	if (an.equals("T2014")) {
		;
		out.println("<img id=imagen src=http://motorsport.tecnun.es/img/work-1.png onmouseover='agrandar()' onmouseout=achicar())>");
		
	}
		if (an.equals("T2013")) {
		
out.println("<img id=imagen src=http://motorsport.tecnun.es/img/work-2.png onmouseover='agrandar()' onmouseout=achicar()>");
		
	}
		if (an.equals("T2012")) {
		
	out.println("<img id=imagen src=http://motorsport.tecnun.es/img/work-3.png onmouseover='agrandar()' onmouseout=achicar()>");
		
	}
		if (an.equals("T2011")) {
		
	out.println("<img id=imagen src=http://motorsport.tecnun.es/img/work-4.png onmouseover='agrandar()' onmouseout=achicar()>");
		
	}
		if (an.equals("T2010")) {
		
	out.println("<img id=imagen src=http://motorsport.tecnun.es/img/work-5.png onmouseover='agrandar()' onmouseout=achicar()>");
		
	}
	out.println("<br/> ");
	out.println("<br/> ");
	out.println("<br/> ");
	out.println("Subir imagen al servidor");
	out.println("<form action='<%= request.getContextPath()%>/UploadFile' method='post' enctype='multipart/form-data'>" );
out.println("<label> ");
out.println("Seleccione el archivo ");
out.println("</label>");
out.println("<input type=hidden name='MAX_FILE_SIZE' value=100000 />");
out.println("<br />");
out.println("<input name='userfile' type='file' />");
out.println("<br/> ");
out.println("<input type='submit' value='Enviar'/> ");
out.println("</form> ");
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