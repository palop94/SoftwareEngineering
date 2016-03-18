import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BuscarPersonas extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {

    super.init(config);
    System.out.println("Iniciando MostrarLibros...");
  } 
        

  public void destroy() {
    System.out.println("No hay nada que hacer...");
  } 
          

  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession(true);

    
    String strGrado = req.getParameter("Grado");
	String strCurso= req.getParameter("Curso");

    devolverPaginaHTML(resp, strCurso, strGrado);
  } 
    
  public void devolverPaginaHTML(HttpServletResponse resp, String curso, String grado) throws IOException {

    resp.setContentType("text/html");

   
    PrintWriter out = null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }
	
        
    File file = new File("Alumnos.txt");
    Scanner scanner = new Scanner(file);
    String line = null;
	
   
   while (scanner.hasNext()) {
        line = scanner.nextLine();
        Scanner lineSc = new Scanner(line);
        lineSc.useDelimiter("\t");
        try {
            String Nom = lineSc.next();
            String cur = lineSc.next();
            String gra = lineSc.next();
			
			if (curso.equals(cur) && grado==null){
				out.println("<HTML>");
				out.println("<HEAD>");
				out.println("<TITLE>Alumnos:</TITLE>");
				out.println("</HEAD>");
				out.println("<BODY TEXT=\"white\" BACKGROUND=\"Fondo2.jpg\" BGPROPERTIES=\"fixed\" style=\"background-repeat: no-repeat; background-size:cover\" leftMargin  topMargin  marginheight  marginwidth>");
				out.println("<BR><font size=\"5\" color=\"black\" face=\"Arial\"> <B>Los alumnos de  </B><font color=\"black\">" + curso + "<B> curso son: </B> </font></FONT>");
				out.println("<P><font size=\"5\" color=\"black\" face=\"Arial\"> <B> Mikel (Organization), Luken (Organization), Jokin(Mecanic) </B></FONT>");
				out.println("</BODY>");
				out.println("<BR><a href=\"BuscarPersonas.html\">Buscar mas usuarios</a>");
				out.println("<BR><a href=\"Inicio\">Ir al menu</a>");
				out.println("</html>");
				out.close();
				
			}else if (grado.equals(gra) && curso==null){
				out.println("<HTML>");
				out.println("<HEAD>");
				out.println("<TITLE>Alumnos:</TITLE>");
				out.println("</HEAD>");
				out.println("<BODY TEXT=\"white\" BACKGROUND=\"Fondo2.jpg\" BGPROPERTIES=\"fixed\" style=\"background-repeat: no-repeat; background-size:cover\" leftMargin  topMargin  marginheight  marginwidth>");
				out.println("<BR><font size=\"5\" color=\"black\" face=\"Arial\"> <B>Los alumnos de  </B><font color=\"black\">" + grado + "<B> son:  </B> </font></FONT>");
				out.println("<P><font size=\"5\" color=\"black\" face=\"Arial\"> <B> Mikel (3) y Luken (3) </B></FONT>");
				out.println("</BODY>");
				out.println("<BR><a href=\"BuscarPersonas.html\">Buscar mas usuarios</a>");
				out.println("<BR><a href=\"Inicio\">Ir al menu</a>");
				out.println("</html>");
				out.close();
			}else{
				out.println("<HTML>");
				out.println("<HEAD>");
				out.println("<TITLE>Sin coincidencias:</TITLE>");
				out.println("</HEAD>");
				out.println("<BODY TEXT=\"white\" BACKGROUND=\"Fondo2.jpg\" BGPROPERTIES=\"fixed\" style=\"background-repeat: no-repeat; background-size:cover\" leftMargin  topMargin  marginheight  marginwidth>");
				out.println("<P><font size=\"5\" color=\"black\" face=\"Arial\"> <B>No hay alumnos que cumplan las condiciones exigidas </B></FONT>");
				out.println("</BODY>");
				out.println("<BR><a href=\"BuscarPersonas.html\">Buscar mas usuarios</a>");
				out.println("<BR><a href=\"Inicio\">Ir al menu</a>");
				out.println("</html>");
				out.close();
			}
        } catch (NoSuchElementException ex) {
            System.out.println("Error en MostrarUsuarios " + ex);
        }

    }

	//La funcion no identifica correctamente los atributos que queremos comparar, porque para eso haria falta un registro, el cual no esta hecho,
	//pero la funcion deberia trabajar de esta manera, que seria con una consulta, y debolvernos los resultados que se muestran, claro esta, dependiendo de la condicion.


	out.println("<BR><a href=\"BuscarUsuario.html\">Buscar mas usuarios</a>");
    out.println("<BR><a href=\"Inicio.html\">Ir al menu</a>");
    out.println("</BODY>");
    out.println("</HTML>");

   
    out.flush();
    out.close();
  } 
     
  
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  } 
}