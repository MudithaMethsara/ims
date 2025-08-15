package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.MySQL;
import lk.redwolfdynamic.ims.model.Teacher;
import lk.redwolfdynamic.ims.model.TeacherDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public List<TeacherDetails> getAllTeacherDetails() {
        List<TeacherDetails> teacherDetailsList = new ArrayList<>();
        String query = "SELECT t.id, t.first_name, t.last_name, t.email, t.phone, d.name AS department_name FROM teacher t JOIN department d ON t.department_id = d.id";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                TeacherDetails details = new TeacherDetails();
                details.setId(rs.getInt("id"));
                details.setFirstName(rs.getString("first_name"));
                details.setLastName(rs.getString("last_name"));
                details.setEmail(rs.getString("email"));
                details.setPhone(rs.getString("phone"));
                details.setDepartmentName(rs.getString("department_name"));
                teacherDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherDetailsList;
    }

    public boolean addTeacher(Teacher teacher) {
        String query = "INSERT INTO teacher (first_name, last_name, email, phone, department_id) VALUES (?, ?, ?, ?, ?)";
        try {
            MySQL.execute(query, teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getPhone(), teacher.getDepartmentId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTeacher(Teacher teacher) {
        String query = "UPDATE teacher SET first_name = ?, last_name = ?, email = ?, phone = ?, department_id = ? WHERE id = ?";
        try {
            MySQL.execute(query, teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getPhone(), teacher.getDepartmentId(), teacher.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeacher(int id) {
        String query = "DELETE FROM teacher WHERE id = ?";
        try {
            MySQL.execute(query, id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTeacherCount() {
        String query = "SELECT COUNT(*) FROM teacher";
        try (ResultSet rs = MySQL.execute(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
