package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.CourseDao;
import lk.redwolfdynamic.ims.dao.StudentDao;
import lk.redwolfdynamic.ims.dao.TeacherDao;
import lk.redwolfdynamic.ims.model.DashboardStats;

public class DashboardService {

    private final StudentDao studentDao;
    private final TeacherDao teacherDao;
    private final CourseDao courseDao;

    public DashboardService() {
        this.studentDao = new StudentDao();
        this.teacherDao = new TeacherDao();
        this.courseDao = new CourseDao();
    }

    public DashboardStats getDashboardStats() {
        DashboardStats stats = new DashboardStats();
        stats.setStudentCount(studentDao.getStudentCount());
        stats.setTeacherCount(teacherDao.getTeacherCount());
        stats.setCourseCount(courseDao.getCourseCount());
        return stats;
    }
}
