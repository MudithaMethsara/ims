package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.Department;
import lk.redwolfdynamic.ims.model.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM department";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean addDepartment(String name) {
        String query = "INSERT INTO department (name) VALUES (?)";
        try {
            MySQL.execute(query, name);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean departmentNameExists(String name) {
        String query = "SELECT COUNT(*) FROM department WHERE name = ?";
        try (ResultSet rs = MySQL.execute(query, name)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
