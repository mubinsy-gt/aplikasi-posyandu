package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {

    public static Connection getConnection() {
        Connection connect = null;
        try {
            String url = "jdbc:mysql://localhost:3306/posyandu";
            String name = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver"); // gunakan com.mysql.cj.jdbc.Driver untuk MySQL 8+
            connect = DriverManager.getConnection(url, name, password);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, Periksa Sambungan: " + e.getMessage());
        }
        return connect;
    }
}
