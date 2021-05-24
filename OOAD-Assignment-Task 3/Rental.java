package entity;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Rental {
    String rentalNr;
    int creationDate;
    int exRetDay;
    int actRetDay;
    float fullCost;
    float actualCost;
    String notes;
    WalkInRental walkInRental;

    public Rental() {
    }

    public Rental(String rentalNr, int creationDate, int exRetDay, String notes) {
        this.rentalNr = rentalNr;
        this.notes = notes;
        this.creationDate = creationDate;
        this.exRetDay = exRetDay;
        this.walkInRental  = new WalkInRental();
    }

    public String getRentalNr() {
        return rentalNr;
    }

    public void setRentalNr(String rentalNr) {
        this.rentalNr = rentalNr;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public int getExRetDay() {
        return exRetDay;
    }

    public void setExRetDay(int exRetDay) {
        this.exRetDay = exRetDay;
    }

    public int getActRetDay() {
        return actRetDay;
    }

    public void setActRetDay(int actRetDay) {
        this.actRetDay = actRetDay;
    }

    public float getFullCost() {
        return fullCost;
    }

    public void setFullCost(float fullCost) {
        this.fullCost = fullCost;
    }

    public float getActualCost() {
        return actualCost;
    }

    public void setActualCost(float actualCost) {
        this.actualCost = actualCost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public WalkInRental getWalkInRental() {
        return walkInRental;
    }

    public void setWalkInRental(WalkInRental walkInRental) {
        this.walkInRental = walkInRental;
    }

    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(!(o instanceof Rental))
            return false;
        Rental rental = (Rental)o;
        return this.rentalNr.equals(rental.getRentalNr());
    }
    @Override
    public int hashCode(){
        return this.rentalNr.hashCode();
    }
}
