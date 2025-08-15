package lk.redwolfdynamic.ims.dao;

import lk.redwolfdynamic.ims.model.MySQL;
import lk.redwolfdynamic.ims.model.Payment;
import lk.redwolfdynamic.ims.model.PaymentDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {

    public List<PaymentDetails> getAllPaymentDetails() {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        String query = "SELECT p.id, CONCAT(s.first_name, ' ', s.last_name) AS student_name, c.name AS course_name, p.amount, p.payment_date " +
                       "FROM payment p " +
                       "JOIN student s ON p.student_id = s.id " +
                       "JOIN course c ON p.course_id = c.id";
        try (ResultSet rs = MySQL.execute(query)) {
            while (rs.next()) {
                PaymentDetails details = new PaymentDetails();
                details.setPaymentId(rs.getInt("id"));
                details.setStudentName(rs.getString("student_name"));
                details.setCourseName(rs.getString("course_name"));
                details.setAmount(rs.getBigDecimal("amount"));
                details.setPaymentDate(rs.getDate("payment_date"));
                paymentDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentDetailsList;
    }

    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO payment (student_id, course_id, amount, payment_date) VALUES (?, ?, ?, ?)";
        try {
            MySQL.execute(query, payment.getStudentId(), payment.getCourseId(), payment.getAmount(), new java.sql.Date(payment.getPaymentDate().getTime()));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
