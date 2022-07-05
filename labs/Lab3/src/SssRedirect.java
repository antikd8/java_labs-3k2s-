import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class SssRedirect extends HttpServlet implements Servlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("SssRedirect: service method " + LocalTime.now());
        //1,2 задание - переадресация GET, POST методов на Ggg сервлет

       if (req.getMethod().equals("GET"))
            resp.sendRedirect(req.getContextPath() + "/GggRedirect");
        if (req.getMethod().equals("POST"))
            resp.sendRedirect(req.getContextPath() + "/GggRedirect?param=" + req.getParameter("param"));

        //3 задание - переадресация на Html-страницу
        //resp.sendRedirect(req.getContextPath()+"/redirect_page.html");

        //4 задание - двойное переадресация
       //  resp.getWriter().print("Выполняется переадресация на сервлет GggRedirect");
       // resp.sendRedirect(req.getContextPath() + "/GggRedirect");
    }
}
