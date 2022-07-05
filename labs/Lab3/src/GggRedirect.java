import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class GggRedirect extends HttpServlet implements Servlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GggRedirect: service method " + LocalTime.now());
        //1,2 задание - обработка запросов переадресованных с Sss
                resp.getWriter().print("Method:" + req.getMethod() + "; Servlet:" + req.getServletPath() + " Params:" + req.getParameter("param"));

        //4 задание - двойное переопределение
       // resp.getWriter().print("Происходит перенаправление на html-страницу");
      //  resp.sendRedirect(req.getContextPath() + "/redirect_page.html");

    }
}
