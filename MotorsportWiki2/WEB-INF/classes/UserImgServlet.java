import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UserImgServlet extends HttpServlet{
    Connection con;
			
	public void init(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("creating connection....");
			con = DriverManager.getConnection("jdbc:odbc:TMSwiki");
			System.out.println("connection created");
		}catch (Exception e){
			System.out.println("db connection failed");
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		// size of byte buffer to send file
		
        String name=request.getParameter("username");

         
        try {
           
            // queries the database
			String query = "SELECT * FROM Usuarios WHERE ID = "+name;
			Statement stmt = con.createStatement();
			System.out.println("created query");
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("executed query");

			response.setContentType("text");
			PrintWriter out = response.getWriter();
 
            if (rs.next()) {
                // gets file name and file blob data
                String fileURL	= rs.getString("imagenURL");

				out.print(fileURL);     
				
            } else {
                // no file found
                out.print("no image");  
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("SQL Error: " + ex.getMessage());
        } catch (IOException ex) {
            //ex.printStackTrace();
            //System.out.println("IO Error: " + ex.getMessage());
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }          
        }
        
    }
    
}