package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.MySQL;
import lk.redwolfdynamic.ims.model.Student;
import lk.redwolfdynamic.ims.model.StudentDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<StudentDetails> getAllStudentDetails() {
        List<StudentDetails> studentDetailsList = new ArrayList<>();
        String query = "SELECT s.id, s.first_name, s.last_name, s.email, s.phone, c.name AS course_name FROM student s JOIN course c ON s.course_id = c.id";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                StudentDetails details = new StudentDetails();
                details.setId(rs.getInt("id"));
                details.setFirstName(rs.getString("first_name"));
                details.setLastName(rs.getString("last_name"));
                details.setEmail(rs.getString("email"));
                details.setPhone(rs.getString("phone"));
                details.setCourseName(rs.getString("course_name"));
                studentDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentDetailsList;
    }

    public boolean addStudent(Student student) {
        String query = "INSERT INTO student (first_name, last_name, email, phone, course_id) VALUES (?, ?, ?, ?, ?)";
        try {
            MySQL.execute(query, student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhone(), student.getCourseId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE student SET first_name = ?, last_name = ?, email = ?, phone = ?, course_id = ? WHERE id = ?";
        try {
            MySQL.execute(query, student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhone(), student.getCourseId(), student.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM student WHERE id = ?";
        try {
            MySQL.execute(query, id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getStudentCount() {
        String query = "SELECT COUNT(*) FROM student";
        try (ResultSet rs = MySQL.execute(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Student> getStudentsByCourseId(int courseId) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student WHERE course_id = ?";
        try (ResultSet rs = MySQL.execute(query, courseId)) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setCourseId(rs.getInt("course_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
