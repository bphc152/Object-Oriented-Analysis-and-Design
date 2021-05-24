package entity;

import globalVariable.GC;

import java.util.HashSet;
import java.util.Set;

public class Car {
    String regNr;
    String status;
    Set<Rental> rentalList;

    public Car() {
    }

    public Car(String regNr) {
        this.regNr = regNr;
        this.status = GC.AVAILABLE;
        this.rentalList = new HashSet<>();
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(Set<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    @Override
    public String toString(){
        return "Car: "+this.regNr + " - "+this.status;
    }
    @Override
    public boolean equals(Object o){
        if(o==this)
            return  true;
        if(!(o instanceof Car))
            return  false;
        Car car = (Car)o;
        return  this.regNr.equals(car.regNr);
    }
    @Override
    public int hashCode(){
        return  this.regNr.hashCode();
    }

}
