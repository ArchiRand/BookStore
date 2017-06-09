package by.bookStore.jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DriverManagerUtil implements ConnectionUtil {

    private Connection connection;
    private static Properties properties = new Properties();

    static { init(); }

    private static void init() {
        try {
            properties.load(new FileInputStream("C:\\Users\\Archi\\BookStore\\src\\main\\resources\\mysql.properties"));
            Class.forName(properties.getProperty("DRIVER_CLASS"));
        }
        catch (IOException e) {
            System.out.println("Cannot read prop file");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Cannot upload the Driver");
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        properties.getProperty("DATABASE_URL"),
                        properties.getProperty("USER_NAME"),
                        properties.getProperty("PASSWORD"));
            }
        } catch (SQLException e) {
            System.out.println("Cannot create a connection");
            e.printStackTrace();
        }
        return connection;
    }

}
