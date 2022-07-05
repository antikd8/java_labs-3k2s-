import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Ggg extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ggg: doGet "+ LocalTime.now());
        resp.getWriter().print("Method:"+req.getMethod()+"; Servlet:"+req.getServletPath()+"; LocalName: "+req.getLocalName()+" Params:"+req.getParameter("param"));
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ggg: doPost "+ LocalTime.now());
        resp.getWriter().print("Method:"+req.getMethod()+"; Servlet:"+req.getServletPath()+"; LocalName: "+req.getLocalName()+" Params:"+req.getParameter("param"));
        resp.getWriter().flush();
    }

    @Override
    public void destroy() {
        System.out.println("Ggg: destroy");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Ggg: init");
        super.init();
    }
}
