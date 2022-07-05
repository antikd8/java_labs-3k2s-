import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Date;
import java.io.*;

public class Sss extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.getWriter().println("Servlet:SSS");
  }

 protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException {
    Date date = new Date();
		String docdir   = getServletContext().getInitParameter("globaldoc-dir");//localdoc-dir
    String wordFile = rq.getParameter("wf");
    System.out.println("Download file: " + wordFile + "  " + date.toString());
    OutputDoc(new File(docdir + wordFile), rs);//загрузка файла клиенту на устройство

	}

  protected void OutputDoc(File doc, HttpServletResponse rs)
			throws IOException {
		rs.setContentType("application/msword");
		rs.addHeader("Content-Disposition", "attachment; filename="+ doc.getName());
		rs.setContentLength((int) doc.length());

		FileInputStream in = new FileInputStream(doc);
		BufferedInputStream buf = new BufferedInputStream(in);
		ServletOutputStream out = rs.getOutputStream();
		int readBytes = 0;
		while ((readBytes = buf.read()) != -1)
			out.write(readBytes);

	}
}
