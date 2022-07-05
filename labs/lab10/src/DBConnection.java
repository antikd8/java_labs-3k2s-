import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

public class DBConnection extends HttpServlet implements Servlet {

    static String url = "jdbc:jtds:sqlserver://80.94.168.145:1433/JDBC_lab10";
    static String user = "student";
    static String password = "Pa$$w0rd";
    Connection connection;

    public void init() throws ServletException {
        super.init();
        System.out.println("DBConnection:init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("DBConnection:destroy");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {

        rs.setCharacterEncoding("CP1251");

        PrintWriter pw = rs.getWriter();

        connection = null;


        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            System.out.println("Driver is registered!");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("You are connected");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from table1");
            String result = "";
            while (resultSet.next()) {
                result += "id:" + resultSet.getInt(1) + "; name:" + resultSet.getString(2) + ";\n";
            }

            pw.println(result);

            statement.close();
            resultSet.close();
            connection.close();
            return;
        } catch (SQLException e) {
            pw.println(e.getStackTrace());
        } catch (ClassNotFoundException a) {
            pw.println(a.getStackTrace());
        } catch (NumberFormatException n) {
            pw.println(n.getStackTrace());
        }

    }
}