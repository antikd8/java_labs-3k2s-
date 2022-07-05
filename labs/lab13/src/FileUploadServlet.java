import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// Огромное спасибо этому человеку, кратко по коду и наконец РАБОТАЕТ, спасибо большчое
// https://zetcode.com/articles/javaservletuploadfile/  


@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
            
        response.setContentType("text/plain;charset=UTF-8");    

        ServletOutputStream os = response.getOutputStream();

        ServletConfig sc = getServletConfig();

        Part filePart = request.getPart("myfile");

        String fileName = filePart.getSubmittedFileName(); 
        InputStream is = filePart.getInputStream();
        Files.copy(is, Paths.get("C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/lab13/files/" + fileName), StandardCopyOption.REPLACE_EXISTING);

        os.print("File successfully uploaded");
    }
}