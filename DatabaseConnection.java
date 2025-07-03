
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class DatabaseConnection {
//     public static Connection getConnection() throws SQLException {
//         return DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "your_password");
//     }
// }


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/user_managemnet";
    private static final String USER = "root";        // change to your username
    private static final String PASSWORD = "password"; // change to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
