package lk.redwolfdynamic.ims.service;

import lk.redwolfdynamic.ims.dao.PaymentDao;
import lk.redwolfdynamic.ims.model.Payment;
import lk.redwolfdynamic.ims.model.PaymentDetails;

import java.math.BigDecimal;
import java.util.List;

public class PaymentService {

    private final PaymentDao paymentDao;

    public PaymentService() {
        this.paymentDao = new PaymentDao();
    }

    public List<PaymentDetails> getAllPaymentDetails() {
        return paymentDao.getAllPaymentDetails();
    }

    public boolean addPayment(Payment payment) {
        if (!isPaymentValid(payment)) {
            return false;
        }
        return paymentDao.addPayment(payment);
    }

    private boolean isPaymentValid(Payment payment) {
        if (payment == null) return false;
        if (payment.getStudentId() <= 0) return false;
        if (payment.getCourseId() <= 0) return false;
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) return false;
        if (payment.getPaymentDate() == null) return false;

        return true;
    }
}
