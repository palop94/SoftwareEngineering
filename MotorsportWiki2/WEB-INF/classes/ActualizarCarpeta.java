import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ActualizarCarpeta extends HttpServlet {
    Connection connection;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:TMSwiki";
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            System.out.println("Problem creating connection");
            e.printStackTrace();
        }
    }

    public void destroy () {
        super.destroy();
        System.out.print("Closing connection ...");
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch(SQLException ex){
            System.out.println("Problem closing connection");
            System.out.println(ex.getMessage());
        }
    }
	
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			String sqlSelect = "SELECT ID, Nombre FROM Carpetas";
            System.out.println(sqlSelect);
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sqlSelect);
			while(result.next()) {
				String ID = result.getString("ID");
				String foname = req.getParameter("name" + ID );
				String ftag1 = req.getParameter("tag1" + ID );
				String ftag2 = req.getParameter("tag2" + ID );
				String ftag3 = req.getParameter("tag3" + ID );
				System.out.println("ID: " + ID+"");
				System.out.println("name" + ID + " : " + foname);
				System.out.println("tag2" + ID +": " + ftag1);
				System.out.println("tag2" + ID +" : " + ftag2);
				System.out.println("tag3" + ID + " : " + ftag3);
				int id = Integer.parseInt(ID);
				if (foname != null && foname!=""){
					Statement upd = null;
					upd=connection.createStatement();
                    String sqlUpdate = "UPDATE Carpetas SET Nombre='" + foname + "' WHERE ID = " + id + "";
                    System.out.println(sqlUpdate);
					upd.executeUpdate(sqlUpdate);
					
				}
				if (ftag1!=null && ftag1!= "" ){
					Statement upd = null;
					upd=connection.createStatement();
                    String sqlUpdate = "UPDATE Carpetas SET Etiqueta_1='" + ftag1 + "' WHERE ID = " + id + "";
                    System.out.println(sqlUpdate);
					upd.executeUpdate(sqlUpdate);
					
				}
				if (ftag2!=null && ftag2!=""){
					Statement upd = null;
					upd=connection.createStatement();
                    String sqlUpdate = "UPDATE Carpetas SET Etiqueta_2='" + ftag2 + "' WHERE ID = " + id + "";
                    System.out.println(sqlUpdate);
					upd.executeUpdate(sqlUpdate);
						
				}
				if (ftag3!=null && ftag3!= ""){
					Statement upd = null;
					upd=connection.createStatement();
                    String sqlUpdate = "UPDATE Carpetas SET Etiqueta_3='" + ftag3 + "' WHERE ID = " + id + "";
                    System.out.println(sqlUpdate);
					upd.executeUpdate(sqlUpdate);
						
				} else {
				System.out.println("No ha funcionado");
				}
			}	
	    } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Exception in ActualizarCarpeta: " + e);
        }
		res.sendRedirect("MostrarCarpetas");
	}
}
	
		
					