import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {

        String url =
                "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=EvidencijaPolaznikaDB;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true";

        String username = "sa";
        String password = "SQL";


        return DriverManager.getConnection(url,username,password);
    }
}
