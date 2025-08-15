package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.DepartmentDao;
import lk.redwolfdynamic.ims.model.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    public boolean addDepartment(String name) {
        // Business logic: prevent blank names and duplicates
        if (name == null || name.trim().isEmpty()) {
            // In a real app, might throw an exception
            return false;
        }
        if (departmentDao.departmentNameExists(name.trim())) {
            // Department already exists
            return false;
        }
        return departmentDao.addDepartment(name.trim());
    }
}
