package entity;

import java.util.Date;

public class Payment {

    String paymentItem;
    float amount;
    int method;
    String creditCardDetails;
    int paymentDate;

    public Payment(String paymentItem, float amount, int method, String creditCardDetails, int paymentDate) {
        this.paymentItem = paymentItem;
        this.amount = amount;
        this.method = method;
        this.creditCardDetails = creditCardDetails;
        this.paymentDate = paymentDate;
    }

    public Payment() {
    }

    public String getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(String paymentItem) {
        this.paymentItem = paymentItem;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(String creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    public int getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(int paymentDate) {
        this.paymentDate = paymentDate;
    }
}
