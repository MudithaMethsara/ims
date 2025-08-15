package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.StudentDao;
import lk.redwolfdynamic.ims.model.Student;
import lk.redwolfdynamic.ims.model.StudentDetails;

import java.util.List;
import java.util.regex.Pattern;

public class StudentService {

    private final StudentDao studentDao;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public List<StudentDetails> getAllStudentDetails() {
        return studentDao.getAllStudentDetails();
    }

    public boolean addStudent(Student student) {
        if (!isStudentValid(student)) {
            return false;
        }
        return studentDao.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        if (!isStudentValid(student) || student.getId() <= 0) {
            return false;
        }
        return studentDao.updateStudent(student);
    }

    public boolean deleteStudent(int id) {
        if (id <= 0) {
            return false;
        }
        return studentDao.deleteStudent(id);
    }

    private boolean isStudentValid(Student student) {
        if (student == null) return false;
        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) return false;
        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) return false;
        if (student.getEmail() == null || !EMAIL_PATTERN.matcher(student.getEmail()).matches()) return false;
        if (student.getPhone() == null || student.getPhone().trim().isEmpty()) return false;
        if (student.getCourseId() <= 0) return false;

        return true;
    }

    public List<Student> getStudentsByCourseId(int courseId) {
        if (courseId <= 0) {
            return new java.util.ArrayList<>();
        }
        return studentDao.getStudentsByCourseId(courseId);
    }
}
