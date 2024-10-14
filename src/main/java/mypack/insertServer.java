//create package for servlet
package mypack;

//import statements for servlet, IO, and SQL
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

//create insertServer class
@WebServlet("/insertServer")
public class insertServer extends HttpServlet {
	final String user = "ausmusbaran@gmail.com";
	
	final String pass = "ijfj ycwe hiqu rlcx";
	
	final String to = "ausmusbaran@gmail.com";
	//must be serializable
	private static final long serialVersionUID = 1L;
       
    //create constructor
	public insertServer() {
        super();
    }

	//create doGet method to handle request and response
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//create doPost method to handle request and response for posting from JSP page to database table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		//out variable to use print writer
		PrintWriter out = response.getWriter();
		//create variables to get parameters from JSP page by name
		String camperId = request.getParameter("camper_id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String churchName = request.getParameter("church_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//store fields from form to variables
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        
        //try catch statement to capture errors
        try {
        //send message
        SendEmail.send(to,subject, message, user, pass);
        //print if sent successfully
        out.println("Mail Sent Successfully");
        }
        catch(Exception e)
		{
			e.printStackTrace();
		}
        
		//instantiate i variable to use for execution of sql and check for exceptions
		int i = 0;
		
		try {
			//get driver class to connection to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection string for sql database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ausmusjdbc", "beardad", "Maroulous@2");
			//sql insert statement from jsp page to database
			PreparedStatement ps = con.prepareStatement("insert into campers(Camper_Id, FirstName, LastName, ChurchName, Email, Phone) values(?,?,?,?,?,?)");
			ps.setInt(1,  Integer.parseInt(camperId));
			ps.setString(2,  firstName);
			ps.setString(3,  lastName); 
			ps.setString(4,  churchName);
			ps.setString(5,  email);
			ps.setInt(6,  Integer.parseInt(phone));
			i = ps.executeUpdate();
		}
		//will print stack trace if there is an exception
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//will be displayed if data successfully written to database
		if (i > 0) {
			out.print("Thank you! Data inserted successfully!");
		}
		//will be displayed if data not written to database
		else
		{
			out.print("Data not inserted...");
		}
	}

}
