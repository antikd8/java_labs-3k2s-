import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class SssReaddress extends HttpServlet implements Servlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SssRedirect: service method " + LocalTime.now());
        // 1,2 задание - переопределение GET и POST запросов
        resp.getWriter().print("Выполняется переопределение на сервлет GggRedirect");
        getServletContext().getRequestDispatcher("/GggReaddress").forward(req, resp);

        //3 задание - переопределение на Html-страницу
        // getServletContext().getRequestDispatcher("/redirect_page.html").forward(req,resp);

        //4 задание - двойное переопределение (с Sss на Ggg и потом на html-страницу)
        // getServletContext().getRequestDispatcher("/GggReaddress").forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("SssRedirect: init " + LocalTime.now());
        super.init(config);
    }
}
