package lk.redwolfdynamic.ims.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private int id;
    private int studentId;
    private int courseId;
    private BigDecimal amount;
    private Date paymentDate;

    public Payment() {
    }

    public Payment(int id, int studentId, int courseId, BigDecimal amount, Date paymentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
