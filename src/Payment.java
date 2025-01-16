enum PaymentStatus {
    PENDING, COMPLETED, FAILED
}

public class Payment {
    private int paymentId;
    private double amount;
    private PaymentStatus status;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public boolean makeTransaction() {
        if (amount > 0) {
            status = PaymentStatus.COMPLETED;
            return true;
        } else {
            status = PaymentStatus.FAILED;
            return false;
        }
    }
}
