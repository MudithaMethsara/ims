package lk.redwolfdynamic.ims.model;

///*import com.mysql.cj.xdevapi.Statement;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL {
    
    private static Connection connection;
    
    private static void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "mrbadboy");
    }
    
    public static ResultSet dataFetch(String sql) throws Exception{
        if(connection ==null){
            connect();
        }
        return connection.createStatement().executeQuery(sql);
    }
    
    public static void dataUpdate(String sql) throws Exception{
        if(connection == null){
            connect();
        }
        connection.createStatement().executeUpdate(sql);
    }
    
}
