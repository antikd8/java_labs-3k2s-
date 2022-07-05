import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class GggReaddress extends HttpServlet implements Servlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GggRedirect: service method " + LocalTime.now());
        //1, 2 задание - обработка запросов принятых с Sss
        resp.getWriter().print("Method:" + req.getMethod() + "; Servlet:" + req.getServletPath() + "; Params=" + req.getParameter("param"));

        // 4 задание - двойное переопределение
       //resp.getWriter().print("Происходт перенаправление на html-страницу");
       //getServletContext().getRequestDispatcher("/redirect_page.html").forward(req, resp);

    }

}
