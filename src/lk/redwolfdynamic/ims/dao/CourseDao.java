package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.Course;
import lk.redwolfdynamic.ims.model.CourseDetails;
import lk.redwolfdynamic.ims.model.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public List<CourseDetails> getAllCourseDetails() {
        List<CourseDetails> courseDetailsList = new ArrayList<>();
        String query = "SELECT c.id, c.name AS course_name, d.name AS department_name FROM course c JOIN department d ON c.department_id = d.id";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                CourseDetails details = new CourseDetails();
                details.setId(rs.getInt("id"));
                details.setCourseName(rs.getString("course_name"));
                details.setDepartmentName(rs.getString("department_name"));
                courseDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseDetailsList;
    }

    public boolean addCourse(String name, int departmentId) {
        String query = "INSERT INTO course (name, department_id) VALUES (?, ?)";
        try {
            MySQL.execute(query, name, departmentId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean courseNameExists(String name) {
        String query = "SELECT COUNT(*) FROM course WHERE name = ?";
        try (ResultSet rs = MySQL.execute(query, name)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Course> getCoursesByDepartment(int departmentId) {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM course WHERE department_id = ?";
        try (ResultSet rs = MySQL.execute(query, departmentId)) {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDepartmentId(rs.getInt("department_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public int getCourseCount() {
        String query = "SELECT COUNT(*) FROM course";
        try (ResultSet rs = MySQL.execute(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM course";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDepartmentId(rs.getInt("department_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
