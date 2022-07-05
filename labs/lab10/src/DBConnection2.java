import java.io.*;
import java.sql.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnection2 extends HttpServlet implements Servlet {

    static String url = "jdbc:jtds:sqlserver://80.94.168.145:1433/JDBC_lab10";
    static String user = "student";
    static String password = "Pa$$w0rd";
    Connection connection;

    public void init() throws ServletException {
        super.init();
        System.out.println("DBConnection2:init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("DBConnection2:destroy");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {

        rs.setCharacterEncoding("CP1251");

        PrintWriter pw = rs.getWriter();

        connection = null;
        String id = req.getParameter("id");

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            System.out.println("Driver is registered!");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("You are connected");

            PreparedStatement statement = connection.prepareStatement("select * from table1 where id=?");
            statement.setInt(1, Integer.parseInt(id));//указываем маркер по очереди в самом запросе и его значение
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                pw.print("There is row with such id!");
                return;
            }
            resultSet = statement.executeQuery();
            String result = "";
            while (resultSet.next()) {
                result += "id:" + resultSet.getInt(1) + "; name:" + resultSet.getString(2) + ";\n";
            }
            pw.println(result);


            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            pw.println(e.getStackTrace());
        } catch (ClassNotFoundException a) {
            pw.println(a.getStackTrace());
        } catch (NumberFormatException n) {
            pw.println(n.getStackTrace());
        }

    }
}