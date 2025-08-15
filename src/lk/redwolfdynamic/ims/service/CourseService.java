package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.CourseDao;
import lk.redwolfdynamic.ims.model.Course;
import lk.redwolfdynamic.ims.model.CourseDetails;

import java.util.List;

public class CourseService {

    private final CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }

    public List<CourseDetails> getAllCourseDetails() {
        return courseDao.getAllCourseDetails();
    }

    public boolean addCourse(String name, int departmentId) {
        if (name == null || name.trim().isEmpty() || departmentId <= 0) {
            return false;
        }
        if (courseDao.courseNameExists(name.trim())) {
            return false;
        }
        return courseDao.addCourse(name.trim(), departmentId);
    }

    public List<Course> getCoursesByDepartment(int departmentId) {
        if (departmentId <= 0) {
            return new java.util.ArrayList<>();
        }
        return courseDao.getCoursesByDepartment(departmentId);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
}
