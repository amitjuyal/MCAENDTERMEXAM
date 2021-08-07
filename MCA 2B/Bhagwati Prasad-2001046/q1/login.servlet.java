package com.jwt.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "user";
    private final String pwd = "12345";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         String user = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select uname,upass from user_reg where uname='"+uname+"' and upass='"+upass+"'");
      
      if(rs.next()) {
        if (userID.equals(user) && pwd.equals(password)) {
            Cookie loginCookie = new Cookie("user", user);
            // setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("loginSuccess.jsp");
        } else {
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color="red">Either user name or password is wrong.</font>");
            requestDispatcher.include(request, response);
        }
 
    }
 
}
