package lab8;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpClient client = new HttpClient();
        String uri = "http://localhost:8080/lab8/Bbb";
        PostMethod postMethod = new PostMethod(uri);

        postMethod.addRequestHeader("X-Aaa1", "1");
        postMethod.addRequestHeader("X-Aaa2", "2");
        postMethod.addRequestHeader("X-Aaa3", "3");
        postMethod.addParameter("X-Aaa1", "1");
        postMethod.addParameter("X-Aaa2", "2");
        postMethod.addParameter("X-Aaa3", "3");

        client.executeMethod(postMethod);

        if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(postMethod.getResponseBodyAsString());

            printWriter.println("All Headers: ");

            Header[] headers = postMethod.getResponseHeaders();

            for (Header header : headers)
                printWriter.println(header.getName() + ": " + header.getValue());
        }
    }
}
