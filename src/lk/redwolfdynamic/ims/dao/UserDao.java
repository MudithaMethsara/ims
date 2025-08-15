package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.MySQL;
import lk.redwolfdynamic.ims.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUserByUsernameAndPasswordAndRole(String username, String password, String role) {
        User user = null;
        String query = "SELECT u.* FROM user u JOIN user_type ut ON u.user_type_id = ut.id WHERE u.username = ? AND u.password = ? AND ut.name = ?";
        try (ResultSet rs = MySQL.execute(query, username, password, role)) {
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserTypeId(rs.getInt("user_type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // In a real application, you might want to log this error or throw a custom exception
        }
        return user;
    }
}
