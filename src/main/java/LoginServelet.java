import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@WebServlet(description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
            @WebInitParam(name="user",value = "Admin"),
             @WebInitParam(name="pwd",value = "Pass")
        }
        )
public class LoginServelet extends HttpServlet {
    protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
        String user=req.getParameter("user");
        String password=req.getParameter("password");

        String userId=getServletConfig().getInitParameter("user");
        String pwd=getServletConfig().getInitParameter("pwd");

        Pattern userPattern = Pattern.compile("^[A-Z]+[a-z]{3,}$");
         Matcher UserMatcher = userPattern.matcher(user);

        if (UserMatcher.matches()) {
            if(userId.equals(user) && pwd.equals(password)){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);

                try {
                    req.getRequestDispatcher("success.jsp").forward(req ,res);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter out = res.getWriter();
                out.println("<font color=red> Incorrect credentials </font>");
                rd.include(req,res);

            }
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = res.getWriter();
            out.println("<font color=red> Use correct naming coventions </font>");
            rd.include(req,res);
        }
    }
}
