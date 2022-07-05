import java.io.IOException; // исключения ввода/вывода
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.*; //интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение
// javax.servlet для http

public class Sss extends HttpServlet implements Servlet {
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        // инициализация сервлета
        super.init();
        System.out.println("Sss:init");
    }

    public void destroy() { // перед уничтожением сервлета
        super.destroy();
        System.out.println("Sss:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String firstName = rq.getParameter("firstname");
        String lastName = rq.getParameter("lastname");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.print("<html>"
                + "<body>"
                + "This is doGet"
                + "<br>" + firstName
                + "<br>" + lastName);
        pw.close();
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String firstName = rq.getParameter("firstname");
        String lastName = rq.getParameter("lastname");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.print("<html>"
                + "<body>"
                + "This is doPost"
                + "<br>" + firstName
                + "<br>" + lastName);
        pw.close();
    }
}
