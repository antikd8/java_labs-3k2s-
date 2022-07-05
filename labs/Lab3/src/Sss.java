import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;


public class Sss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod("http://localhost:8080"+req.getContextPath()+"/Ggg?param=abcd");
        httpClient.executeMethod(getMethod);
        resp.getWriter().print(getMethod.getResponseBodyAsString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8080"+req.getContextPath()+"/Ggg");
        NameValuePair[] params = {new NameValuePair("param","generating post method")};
        postMethod.addParameters(params);
        httpClient.executeMethod(postMethod);
        if(postMethod.getStatusCode()==HttpStatus.SC_OK)
            resp.getWriter().print(postMethod.getResponseBodyAsString());
    }

    @Override
    public void destroy() {
        System.out.println("Sss: destroy "+ LocalTime.now());
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Sss: init "+ LocalTime.now());
        super.init();
    }
}
