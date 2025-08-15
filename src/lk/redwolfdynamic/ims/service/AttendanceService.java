package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.AttendanceDao;
import lk.redwolfdynamic.ims.model.AttendanceStudent;
import lk.redwolfdynamic.ims.model.AttendanceTeacher;

import java.util.Date;
import java.util.List;

public class AttendanceService {

    private final AttendanceDao attendanceDao;

    public AttendanceService() {
        this.attendanceDao = new AttendanceDao();
    }

    // --- Student Attendance ---

    public boolean addStudentAttendance(AttendanceStudent attendance) {
        if (attendance == null || attendance.getStudentId() <= 0 || attendance.getDate() == null || attendance.getStatus() == null) {
            return false;
        }
        return attendanceDao.addStudentAttendance(attendance);
    }

    public List<AttendanceStudent> getStudentAttendanceByDate(Date date) {
        if (date == null) {
            return new java.util.ArrayList<>();
        }
        return attendanceDao.getStudentAttendanceByDate(date);
    }

    // --- Teacher Attendance ---

    public boolean addTeacherAttendance(AttendanceTeacher attendance) {
        if (attendance == null || attendance.getTeacherId() <= 0 || attendance.getDate() == null || attendance.getStatus() == null) {
            return false;
        }
        return attendanceDao.addTeacherAttendance(attendance);
    }

    public List<AttendanceTeacher> getTeacherAttendanceByDate(Date date) {
        if (date == null) {
            return new java.util.ArrayList<>();
        }
        return attendanceDao.getTeacherAttendanceByDate(date);
    }
}
