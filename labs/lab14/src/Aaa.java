import java.io.*;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import org.apache.jackrabbit.webdav.client.methods.CopyMethod;
import org.apache.jackrabbit.webdav.client.methods.DeleteMethod;
import org.apache.jackrabbit.webdav.client.methods.MkColMethod;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Aaa extends HttpServlet implements Servlet {

    String uri = "https://webdav.yandex.ru";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {

        String action = rq.getParameter("action");
        rs.setContentType("text/html");

        switch (action) {
            case "mkcol":
                ActionCreateFolder(rq, rs); //создать папку на яндекс.диске (порой не с первого раза, надо страницу с адресом этим перезагружать)
                break;

            case "download":
                ActionDownload(rq, rs); //скачать с Яндекс.диска, тож подождать надо
                break;
            case "copy":
                ActionCopy(rq, rs); // ооооочень долго грузит, но работает
                break;
            case "deleteFile":
                ActionDeleteFile(rq, rs); // удаление файла
                break;
            case "deleteFolder":
                ActionDeleteFolder(rq, rs); // удаление папки
                break;
            default:
                rs.getWriter().println("<br><br>" + "Error :C");
                break;
        }

        // https://hc.apache.org/httpclient-legacy/apidocs/org/apache/commons/httpclient/HttpMethodBase.html
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) // UPLOAD 
            throws IOException, ServletException {

        Part filePart = rq.getPart("myfile");

        String fileName = filePart.getSubmittedFileName();
        InputStream is = filePart.getInputStream();
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
        String sha = org.apache.commons.codec.digest.DigestUtils.sha256Hex(is);
        byte[] arr = new byte[filePart.getInputStream().available()];
        filePart.getInputStream().read(arr);

        HttpClient client = new HttpClient();
        PutMethod method = new PutMethod(uri + "/" + fileName);
        method.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");

        method.addRequestHeader("Etag", md5);
        method.addRequestHeader("Sha256", sha);

        method.setUseExpectHeader(true);
        method.addRequestHeader("Expect", "100-continue");
        method.addRequestHeader("Content-Type", "application/binary");
        method.addRequestHeader("Content-Length", arr.length + "");

        RequestEntity entity = new ByteArrayRequestEntity(arr);
        method.setRequestEntity(entity);

        int result = client.executeMethod(method);
        rs.setContentType("text/html");

        if (result == 201) {
            rs.getWriter().write("Success <br> <a href='/lab14/'>Back</a>");
        } else {
            rs.getWriter().write("Error " + result + " <br> <a href='/lab14/'>Back</a>");
        }
    }

    protected void ActionDeleteFolder(HttpServletRequest rq, HttpServletResponse rs) throws IOException {

        HttpClient hc = new HttpClient();

        DeleteMethod dm = new DeleteMethod(uri + "/NewFolder/"); //удалить папку New Folder

        dm.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");

        hc.executeMethod(dm);

        rs.getWriter().println("<br><br>" + "The folder has been deleted. Check Yandex.cloud");


    }

    protected void ActionDeleteFile(HttpServletRequest rq, HttpServletResponse rs) throws IOException {

        HttpClient hc = new HttpClient();

        DeleteMethod dm = new DeleteMethod(uri + "/Bears.jpg"); //удалить файл Bears.jpg

        dm.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");

        hc.executeMethod(dm);

        rs.getWriter().println("<br><br>" + "The file has been deleted. Check Yandex.cloud");
    }

    protected void ActionCreateFolder(HttpServletRequest rq, HttpServletResponse rs) throws IOException {

        HttpClient hc = new HttpClient();

        MkColMethod method = new MkColMethod(uri + "/NewFolder/"); //создать папку NewFolder

        method.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");

        hc.executeMethod(method);

        rs.getWriter().println("<br><br>" + "Create new folder. Check Yandex.disk");
    }

    protected void ActionCopy(HttpServletRequest rq, HttpServletResponse rs) throws IOException {

        HttpClient hc = new HttpClient();

        String from = "Bears.jpg", to = "NewFolder/Bears.jpg"; //копировать картинку из корневого каталога в новый каталог с тем же именем

        CopyMethod method = new CopyMethod(uri + "/" + from, uri + "/" + to, true, true);

        method.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");

        hc.executeMethod(method);

        rs.getWriter().println("<br><br>" + "Copy. Check Yandex.disk");
    }

    protected void ActionDownload(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {

        String file = "Bears.jpg"; //скачать картинку эту

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(uri + "/" + file);
        method.addRequestHeader("Authorization", "Basic YW50aWtkODg4ODpoYnRqaW5temh0cm5yaGJk");
        method.addRequestHeader("Accept", "*/*");
        int res = client.executeMethod(method);

        byte[] responseBody = method.getResponseBody();

        if (res == 200) {
            rs.setContentLength((int) method.getResponseContentLength());
            rs.addHeader("Content-Disposition", "attachment; filename=" + file);
            rs.setContentLength((int) method.getResponseContentLength());
            rs.setContentType("image/jpeg");
            rs.getOutputStream().write(responseBody);
        } else {
            rs.setContentType("text/html");
            rs.getWriter().write("Error " + res + " <br> <a href='/lab14/'>Back</a>");
        }
    }

}   
