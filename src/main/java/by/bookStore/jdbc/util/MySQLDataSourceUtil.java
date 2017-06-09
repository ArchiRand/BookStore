package by.bookStore.jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySQLDataSourceUtil implements ConnectionUtil {

    private static MysqlDataSource mysqlDataSource;
    private Connection connection;

    static {
        Properties properties = new Properties();
        try {
            mysqlDataSource = new MysqlDataSource();
            properties.load(new FileInputStream("C:\\Users\\Archi\\BookStore\\src\\main\\resources\\mysql.properties"));
            mysqlDataSource.setUrl(properties.getProperty("DATABASE_URL"));
            mysqlDataSource.setUser(properties.getProperty("USER_NAME"));
            mysqlDataSource.setPassword(properties.getProperty("PASSWORD"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = mysqlDataSource.getConnection();
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return connection;
    }
}
