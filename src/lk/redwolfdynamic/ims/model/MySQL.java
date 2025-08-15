package lk.redwolfdynamic.ims.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {

    private static Connection connection;
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/resources/config/db.properties"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + properties.getProperty("db.host") + ":" + properties.getProperty("db.port") + "/" + properties.getProperty("db.name");
            connection = DriverManager.getConnection(url, properties.getProperty("db.username"), properties.getProperty("db.password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // In a real app, you'd want to handle this more gracefully
            // Maybe show an error dialog to the user
            throw new RuntimeException("Failed to initialize database connection.", e);
        }
    }

    public static ResultSet execute(String query, Object... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }

        if (query.trim().toUpperCase().startsWith("SELECT")) {
            return preparedStatement.executeQuery();
        } else {
            preparedStatement.executeUpdate();
            return null;
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

}
