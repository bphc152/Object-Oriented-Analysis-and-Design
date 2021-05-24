package entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    String licenseNr;
    String name;
    String phoneNr;
    boolean isDiscount;
    boolean isBlackList;
    Set<Rental> rentalList;
    public Customer(String licenseNr, String name, String phoneNr, boolean isDiscount, boolean isBlackList) {
        this.licenseNr = licenseNr;
        this.name = name;
        this.phoneNr = phoneNr;
        this.isDiscount = isDiscount;
        this.isBlackList = isBlackList;
        this.rentalList=new HashSet<>();
    }

    public Customer() {
    }

    public String getLicenseNr() {
        return licenseNr;
    }

    public void setLicenseNr(String licenseNr) {
        this.licenseNr = licenseNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    public boolean isBlackList() {
        return isBlackList;
    }

    public void setBlackList(boolean blackList) {
        isBlackList = blackList;
    }

    public Set<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(Set<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(!(o instanceof Customer))
            return  false;
        return this.licenseNr.equals(((Customer) o).licenseNr);
    }
    @Override
    public int hashCode(){
        return licenseNr.hashCode();
    }
}
