//Almacena los usuarios favoritos del usuario en un txt

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CrearCarpeta extends HttpServlet {
     
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    System.out.println("Iniciando CrearCarpeta...");
  }

  public void destroy() {
    System.out.println("No hay nada que hacer...");
  }

  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
	HttpSession session = req.getSession(true);
    String sesion = (String)session.getAttribute("sesion");
    
    String strNombre = req.getParameter("Nombre");
    String strFecha = req.getParameter("fecha");
    String strEtiqueta1 = req.getParameter("etiqueta1");
    String strEtiqueta2 = req.getParameter("etiqueta2");  
    String strEtiqueta3 = req.getParameter("etiqueta3");  
	  
    FileWriter fileWriter = new FileWriter("Carpetas.txt", true);
    PrintWriter toFile = new PrintWriter(fileWriter);
    
    
    toFile.println("> Carpeta: " + "\t" + strNombre + "\t" + strFecha + "\t" + strEtiqueta1 + "\t" + strEtiqueta2 + "\t" + strEtiqueta3);
    fileWriter.close();
    devolverPaginaHTML(resp, strNombre, strFecha, strEtiqueta1, strEtiqueta2,strEtiqueta3);
  }
    
  public void devolverPaginaHTML(HttpServletResponse resp, String Nombre, String Fecha, String Etiqueta1, String Etiqueta2, String Etiqueta3)  throws IOException {

    resp.setContentType("text/html");

    PrintWriter out = null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }
        
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Carpeta creada:</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY TEXT=\"white\" BACKGROUND=\"Fondo2.jpg\" BGPROPERTIES=\"fixed\" style=\"background-repeat: no-repeat; background-size:cover\" leftMargin  topMargin  marginheight  marginwidth>");
    out.println("<P><font size=\"5\" color=\"black\" face=\"Arial\"> <B>Nombre de la carpeta: </B><font color=\"black\">" + Nombre + "</font></FONT>");
    out.println("<BR><font size=\"5\" color=\"black\" face=\"Arial\"> <B>Fecha: </B><font color=\"black\">" + Fecha + "</font></FONT>");
    out.println("<BR><font size=\"5\" color=\"black\" face=\"Arial\"> <B>Etiquetas: </B><font color=\"black\">" + Etiqueta1 + " / " + Etiqueta2 + " / " + Etiqueta3 + " / " + "</font></FONT>");
	out.println("</BODY>");
    out.println("<BR><a href=\"CrearCarpeta.html\">Crear mas carpetas</a>");
    out.println("<BR><a href=\"Inicio.html\">Ir al menu</a>");

    out.println("</HTML>");

    out.flush();
    out.close();
  }
     
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  }
}