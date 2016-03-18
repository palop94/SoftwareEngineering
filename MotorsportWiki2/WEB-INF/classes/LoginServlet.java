import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class LoginServlet extends HttpServlet{
	
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
        
        String name=request.getParameter("username");
        String pass=request.getParameter("password");
		
			
        try{
        if(validate(name,pass)){

            //Log user into the system. Redirect to main page.
            response.setContentType("text");
			
			PrintWriter out = response.getWriter();
            out.print("succeeded");
            out.flush();
            out.close();

            
        }else{
            //login failed

            response.setContentType("text");

            PrintWriter out = response.getWriter();
            
            out.print("failed");
            out.flush();
            out.close();

        }
		}catch(Exception e){
			System.out.println("db validation failed");
			System.out.println(e);
			
            response.setContentType("text");
            PrintWriter out = response.getWriter();
            out.print("failed");
            out.flush();
            out.close();
		}
        
        
    }
    
    public boolean validate(String name, String pass) throws Exception{
        
        boolean status=false;
        
        //logic to reference database and check username
        System.out.println("checking user "+name);   
		String query = "SELECT * FROM Usuarios WHERE ID="+name+";";

		Statement stmt = con.createStatement();
		
		System.out.println("executing Statement");
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("statement executed");
				
		while (rs.next()) {
	      //System.out.println("getting results");
		  //String dn = rs.getString("Nombre");
		  //System.out.println("name"+dn);
		  String dname = rs.getString("ID");
		  String dpass = rs.getString("Contrasena");
		  
		  //System.out.println("From DB: User:"+dname+" Password:"+dpass);
		  //System.out.println("compare :"+pass+":"+dpass);
		  
		  if (pass.equals(dpass)){
			  System.out.println("Correct credentials");
			  status=true;
		  }else{
			  System.out.println("incorrect credentials");
			  //status=false;
		  }
		}
        return status;
    }
	
	public void destroy(){
		try{
			con.close();
		}catch (Exception e){
			System.out.println("con . close failed");
		}
	}
}