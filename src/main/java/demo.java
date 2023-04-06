import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello")
public class demo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        res.setContentType("text/html");
        try {
            res.getWriter().println("<h1>Java Home</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
