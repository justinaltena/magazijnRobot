package Robot;

import java.awt.Point;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.rowset.CachedRowSetImpl;

public class dbConnection {

    private static String username = "root";
    private static String password = "";

    private static String connectionString = "jdbc:mysql://localhost/kbs2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Connection connection;
    private static Statement command;
    private static ResultSet dbData;
    private static CachedRowSetImpl data;

    public static void main() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
            command = connection.createStatement();
            dbData = command.executeQuery("SELECT * FROM product");
            data = new CachedRowSetImpl();
            data.populate(dbData);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //XMLorderDOM.main();
        Order order = XMLorderDOM.orderFile;
//        for (Product p : order.getProducts()) {
//            System.out.println(p);
        //       }
        try {
            for (Product p : order.getProducts()) {
                data.first();
                do {
                    if (p.getProduct_id() == data.getInt("product_id") && p.checked == false) {
                        p.setProduct_position(new Point(data.getInt("x-coordinate"), data.getInt("y-coordinate")));
                        p.setProduct_size(data.getInt("size"));
                        p.checked = true;
                        data.deleteRow();
                    }
                    //System.out.println(data.getRow());
                } while (data.next());
            }
            connection.close();
//                int waarde1 = data.getInt("x-coordinate");
//                System.out.println(waarde1);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
