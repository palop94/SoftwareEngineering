import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistroComentario extends HttpServlet {
     
 
  public void init(ServletConfig config) throws ServletException {
   
    super.init(config);
    System.out.println("Iniciando RegistroComentario...");
  } 
  public void destroy() {
    System.out.println("No hay nada que hacer...");
  } 
          
  
  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String strComentario = req.getParameter("comentario");
    String strAutor = req.getParameter("autor");              
    FileWriter fileWriter = new FileWriter("lista.txt", true);
    PrintWriter toFile = new PrintWriter(fileWriter);
    toFile.println(strComentario + "\t" + strAutor);
    fileWriter.close();
   
    devolverPaginaHTML(resp, strComentario, strAutor);
  } 
    
  public void devolverPaginaHTML(HttpServletResponse resp,
    String comentario, String autor) {
    
    resp.setContentType("text/html");


    PrintWriter out = null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }
        

    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Comment</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>Comment by autor: </FONT></B>");
    out.println("<P><FONT size=+1><B>Comment </B>" + comentario + "</FONT>");
    out.println("<BR><FONT size=+1><B>Autor: </B>" + autor + "</FONT>");
	out.println("</BODY>");
    out.println("<BR><a href=\"Inicio.html\">Go back to home page</a>");

    out.println("</HTML>");

   
    out.flush();
    out.close();
  } 
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  } 
}
