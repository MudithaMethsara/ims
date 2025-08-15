package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.ExamDao;
import lk.redwolfdynamic.ims.model.Exam;
import lk.redwolfdynamic.ims.model.ScheduledExamDetails;

import java.util.List;

public class ExamService {

    private final ExamDao examDao;

    public ExamService() {
        this.examDao = new ExamDao();
    }

    public List<ScheduledExamDetails> getAllScheduledExamDetails() {
        return examDao.getAllScheduledExamDetails();
    }

    public boolean addScheduledExam(Exam exam) {
        if (!isExamValid(exam)) {
            return false;
        }
        return examDao.addScheduledExam(exam);
    }

    public boolean updateScheduledExam(Exam exam) {
        if (!isExamValid(exam) || exam.getId() <= 0) {
            return false;
        }
        return examDao.updateScheduledExam(exam);
    }

    private boolean isExamValid(Exam exam) {
        if (exam == null) return false;
        if (exam.getName() == null || exam.getName().trim().isEmpty()) return false;
        if (exam.getCourseId() <= 0) return false;
        if (exam.getDate() == null) return false;
        if (exam.getTime() == null || exam.getTime().trim().isEmpty()) return false;

        return true;
    }
}
