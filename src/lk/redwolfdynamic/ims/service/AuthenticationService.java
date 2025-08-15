package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.UserDao;
import lk.redwolfdynamic.ims.model.User;

public class AuthenticationService {

    private final UserDao userDao;

    public AuthenticationService() {
        this.userDao = new UserDao();
    }

    public User login(String username, String password, String role) {
        // Basic validation
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            role == null || role.trim().isEmpty()) {
            return null; // Or throw a specific exception for blank fields
        }

        // Call DAO to get user
        User user = userDao.getUserByUsernameAndPasswordAndRole(username, password, role);

        return user; // Returns the user object on success, null on failure
    }
}
