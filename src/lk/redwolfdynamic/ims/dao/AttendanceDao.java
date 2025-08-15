package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.AttendanceStudent;
import lk.redwolfdynamic.ims.model.AttendanceTeacher;
import lk.redwolfdynamic.ims.model.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceDao {

    // --- Student Attendance ---

    public boolean addStudentAttendance(AttendanceStudent attendance) {
        String query = "INSERT INTO attendance_student (student_id, date, status) VALUES (?, ?, ?)";
        try {
            MySQL.execute(query, attendance.getStudentId(), new java.sql.Date(attendance.getDate().getTime()), attendance.getStatus());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AttendanceStudent> getStudentAttendanceByDate(Date date) {
        List<AttendanceStudent> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM attendance_student WHERE date = ?";
        try (ResultSet rs = MySQL.execute(query, new java.sql.Date(date.getTime()))) {
            while (rs.next()) {
                AttendanceStudent attendance = new AttendanceStudent();
                attendance.setId(rs.getInt("id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setDate(rs.getDate("date"));
                attendance.setStatus(rs.getString("status"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    // --- Teacher Attendance ---

    public boolean addTeacherAttendance(AttendanceTeacher attendance) {
        String query = "INSERT INTO attendance_teacher (teacher_id, date, status) VALUES (?, ?, ?)";
        try {
            MySQL.execute(query, attendance.getTeacherId(), new java.sql.Date(attendance.getDate().getTime()), attendance.getStatus());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AttendanceTeacher> getTeacherAttendanceByDate(Date date) {
        List<AttendanceTeacher> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM attendance_teacher WHERE date = ?";
        try (ResultSet rs = MySQL.execute(query, new java.sql.Date(date.getTime()))) {
            while (rs.next()) {
                AttendanceTeacher attendance = new AttendanceTeacher();
                attendance.setId(rs.getInt("id"));
                attendance.setTeacherId(rs.getInt("teacher_id"));
                attendance.setDate(rs.getDate("date"));
                attendance.setStatus(rs.getString("status"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
}
