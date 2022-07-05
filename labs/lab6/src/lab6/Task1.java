package lab6;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Task1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("This is task1 servlet; urln = 2");
    }
}
