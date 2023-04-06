import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServelet extends HttpServlet {
    protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
        String userName=req.getParameter("user");
        String password=req.getParameter("password");

        if(userName.equals("admin") && password.equals("password")){
            HttpSession session=req.getSession();
            session.setAttribute(userName,userName);;
            try {
                res.sendRedirect("success.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = res.getWriter();
            out.println("<font color=red> Incorrect credentials </font>");
            rd.include(req,res);

        }
    }
}
