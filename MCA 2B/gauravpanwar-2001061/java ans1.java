<!DOCTYPE html>
<html>
<head>
<title>question one</title>
</head>
<body>
	<form action="login">
		<label>User name</label> <input type="text" placeholder="enter your username.."
		name="login"/> <br/><br/>
		<label>Password</label> <input type="text" placeholder="enter password..."
		name="password"/> <br/><br/>
		<button type="submit">login</button><br/>
	</form>
</body>
</html>
import java.sql.*;

public class conn {
    public static boolean checkUser(String email,String pass)
    {
        boolean st =false;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abcd");
            PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        if(conn.checkUser(username, pass)){
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
    }
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Welcome user");
    }
}
