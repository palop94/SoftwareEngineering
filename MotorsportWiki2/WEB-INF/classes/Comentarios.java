import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Comentarios extends HttpServlet {
     

  public void init(ServletConfig config) throws ServletException {
  
    super.init(config);
    System.out.println("Iniciando Comements...");
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
    out.println("<TITLE>Comments by people</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>Comments:</FONT></B>");
    File file = new File("lista.txt");
    Scanner scanner = new Scanner(file);

    String line = null;
    String strout = "";
    strout += "<TABLE border=1>";
    strout += "<TR>";
    strout += "<TH>";
    strout += "Comment";
    strout += "</TH>";
    strout += "<TH>";
    strout += "Autor";
    strout += "</TH>";
    strout += "</TR>";
    while (scanner.hasNext()) {
        line = scanner.nextLine();
        Scanner lineSc = new Scanner(line);
        lineSc.useDelimiter("\t");
        try {
            String comentario = lineSc.next();
            String autor = lineSc.next();
            strout += "<TR>";
            strout += "<TD>";
            strout += comentario;
            strout += "</TD>";
            strout += "<TD>";
            strout += autor;
            strout += "</TD>";
            strout += "</TR>";
        } catch (NoSuchElementException ex) {
            System.out.println("Error in comments " + ex);
        }

    }
    strout += "</TABLE>";

    out.println(strout);
    out.println("<BR><a href=\"Inicio.html\">Go back to home page</a>");
    out.println("</BODY>");
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