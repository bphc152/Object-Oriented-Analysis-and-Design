package entity;

public class WalkInRental {
    String status;
    Payment payment;
    String rentalNr;

    public WalkInRental() {
    }

    public WalkInRental(String rentalNr,String status, Payment payment) {
        this.rentalNr = rentalNr;
        this.status = status;
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getRentalNr() {
        return rentalNr;
    }

    public void setRentalNr(String rentalNr) {
        this.rentalNr = rentalNr;
    }
}
