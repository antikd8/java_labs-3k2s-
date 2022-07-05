import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDateTime;

public class Jjj extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = null;
        if (LocalDateTime.now().getHour() > 6 && LocalDateTime.now().getHour() < 12)
            rd =req.getRequestDispatcher("morning.jsp");
        if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 16)
            rd =req.getRequestDispatcher("afternoon.jsp");
        if (LocalDateTime.now().getHour() >= 17 && LocalDateTime.now().getHour() <= 20)
            rd =req.getRequestDispatcher("evening.jsp");
        if (LocalDateTime.now().getHour() >= 21 || LocalDateTime.now().getHour() <= 6)
            rd =req.getRequestDispatcher("night.jsp");
        rd.forward(req,res);
    }
}
