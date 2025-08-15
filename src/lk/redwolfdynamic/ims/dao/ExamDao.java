package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.Exam;
import lk.redwolfdynamic.ims.model.ScheduledExamDetails;
import lk.redwolfdynamic.ims.model.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {

    public List<ScheduledExamDetails> getAllScheduledExamDetails() {
        List<ScheduledExamDetails> examDetailsList = new ArrayList<>();
        // NOTE: Assumes a 'scheduled_exam' table exists with the specified columns.
        String query = "SELECT se.id, se.name, se.exam_date, se.exam_time, c.name AS course_name " +
                       "FROM scheduled_exam se " +
                       "JOIN course c ON se.course_id = c.id";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                ScheduledExamDetails details = new ScheduledExamDetails();
                details.setId(rs.getInt("id"));
                details.setExamName(rs.getString("name"));
                details.setCourseName(rs.getString("course_name"));
                details.setDate(rs.getDate("exam_date"));
                details.setTime(rs.getString("exam_time"));
                examDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examDetailsList;
    }

    public boolean addScheduledExam(Exam exam) {
        // NOTE: Assumes a 'scheduled_exam' table exists.
        String query = "INSERT INTO scheduled_exam (name, course_id, exam_date, exam_time) VALUES (?, ?, ?, ?)";
        try {
            MySQL.execute(query, exam.getName(), exam.getCourseId(), new java.sql.Date(exam.getDate().getTime()), exam.getTime());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateScheduledExam(Exam exam) {
        // NOTE: Assumes a 'scheduled_exam' table exists.
        String query = "UPDATE scheduled_exam SET name = ?, course_id = ?, exam_date = ?, exam_time = ? WHERE id = ?";
        try {
            MySQL.execute(query, exam.getName(), exam.getCourseId(), new java.sql.Date(exam.getDate().getTime()), exam.getTime(), exam.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
