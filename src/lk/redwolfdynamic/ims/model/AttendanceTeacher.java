package lk.redwolfdynamic.ims.model;

import java.util.Date;

public class AttendanceTeacher {
    private int id;
    private int teacherId;
    private Date date;
    private String status;

    public AttendanceTeacher() {
    }

    public AttendanceTeacher(int id, int teacherId, Date date, String status) {
        this.id = id;
        this.teacherId = teacherId;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
