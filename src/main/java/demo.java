import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class demo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        res.setContentType("text/html");
        res.getWriter().println("<h1>Hello World</h1>");
    }
}
