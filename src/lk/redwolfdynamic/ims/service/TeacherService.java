package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.TeacherDao;
import lk.redwolfdynamic.ims.model.Teacher;
import lk.redwolfdynamic.ims.model.TeacherDetails;

import java.util.List;
import java.util.regex.Pattern;

public class TeacherService {

    private final TeacherDao teacherDao;
    // Basic email regex
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public TeacherService() {
        this.teacherDao = new TeacherDao();
    }

    public List<TeacherDetails> getAllTeacherDetails() {
        return teacherDao.getAllTeacherDetails();
    }

    public boolean addTeacher(Teacher teacher) {
        if (!isTeacherValid(teacher)) {
            return false;
        }
        return teacherDao.addTeacher(teacher);
    }

    public boolean updateTeacher(Teacher teacher) {
        if (!isTeacherValid(teacher) || teacher.getId() <= 0) {
            return false;
        }
        return teacherDao.updateTeacher(teacher);
    }

    public boolean deleteTeacher(int id) {
        if (id <= 0) {
            return false;
        }
        return teacherDao.deleteTeacher(id);
    }

    private boolean isTeacherValid(Teacher teacher) {
        if (teacher == null) return false;
        if (teacher.getFirstName() == null || teacher.getFirstName().trim().isEmpty()) return false;
        if (teacher.getLastName() == null || teacher.getLastName().trim().isEmpty()) return false;
        if (teacher.getEmail() == null || !EMAIL_PATTERN.matcher(teacher.getEmail()).matches()) return false;
        if (teacher.getPhone() == null || teacher.getPhone().trim().isEmpty()) return false; // Basic check
        if (teacher.getDepartmentId() <= 0) return false;

        return true;
    }
}
