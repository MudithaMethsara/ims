package lk.redwolfdynamic.ims.model;

import java.util.Date;

public class Exam {
    private int id;
    private String name;
    private int courseId;
    private Date date;
    private String time;

    public Exam() {
    }

    public Exam(int id, String name, int courseId, Date date, String time) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
