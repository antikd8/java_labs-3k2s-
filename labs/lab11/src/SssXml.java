import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SssXml", urlPatterns = "/SssXml")
public class SssXml extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           System.out.println("SssXml: Hello");

        try {
            Random random = new Random();
            int n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>\n");

           System.out.println("SssXml: after Random");

            int j =  random.nextInt(5) + 5;
            textResult.append("<rand>").append("\n");
            for (int i = 0; i < j; i++) {
                Integer number = random.nextInt(2*n-1) - n;
                textResult.append("<num>").append(number).append("</num>").append("\n");
            }
            textResult.append("</rand>");
            Thread.sleep(1000);
            response.setContentType("text/xml");
            response.getWriter().println(textResult);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
