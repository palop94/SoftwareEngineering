import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MostrarBusquedas extends HttpServlet {
	
  public void init(ServletConfig config) throws ServletException {
    
    super.init(config);
    System.out.println("Iniciando MostrarBusquedas...");
  } 
        
 
  public void destroy() {
    System.out.println("No hay nada que hacer...");
  }
          
  
  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    devolverPaginaHTML(resp);
  } 
    
  public void devolverPaginaHTML(HttpServletResponse resp) 
      throws IOException {
	
	
	
	resp.setContentType("text/html");

    
    PrintWriter out = null;
	
	
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }
      

	out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Busquedas realizadas</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>Busquedas realizadas: </FONT></B>");
    File file = new File("listaBusquedas.txt");
    Scanner scanner = new Scanner(file);

    String line = null;
    String strout = "";
    strout += "<TABLE border=1>";
    strout += "<TR>";
    strout += "<TH>";
    strout += "Tipo";
    strout += "</TH>";
    strout += "<TH>";
    strout += "Busqueda";
    strout += "</TH>";
    strout += "</TR>";
	
    boolean par = false;
    while (scanner.hasNext()) {
        line = scanner.nextLine();
        Scanner lineSc = new Scanner(line);
        lineSc.useDelimiter("\t");
        try {
            String tipo = lineSc.next();
            String busqueda = lineSc.next();
            
            if (par) {
                strout += "<TR>";
            } else {
                strout += "<TR bgcolor=#AAAAAA>";
            }
            par = !par;
            strout += "<TD>";
            strout += tipo;
            strout += "</TD>";
            strout += "<TD>";
            strout += busqueda;
            strout += "</TD>";
           
            strout += "</TR>";
        } catch (NoSuchElementException ex) {
            System.out.println("Error en MostrarBusquedas " + ex);
        }

    }
    strout += "</TABLE>";

    out.println(strout);
    out.println("<BR><a href=\"busqueda.html\">Hacer busqueda nueva</a>");
    out.println("</BODY>");
    out.println("</HTML>");
	 }
}
