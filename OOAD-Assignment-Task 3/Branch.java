package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Branch {
    String branchNr;
    String address;
    String phoneNr;
    List <Car> cars;
    Set<Branch> neighbor;

    public Branch() {
    }

    public Branch(String branchNr, String address, String phoneNr) {
        this.branchNr = branchNr;
        this.address = address;
        this.phoneNr = phoneNr;
        this.neighbor = new HashSet<>();
        this.cars = new ArrayList<>();
    }

    public String getBranchNr() {
        return branchNr;
    }

    public void setBranchNr(String branchNr) {
        this.branchNr = branchNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void displayListCar(){
        for (Car c:this.cars){
            System.out.println(c);
        }
    }

    public Set<Branch> getNeigbor() {
        return neighbor;
    }

    public void setNeighbor(Set<Branch> neigbor) {
        this.neighbor = neigbor;
    }
    public void addNeighbor(Branch branch){this.neighbor.add(branch);}

    public boolean checkCarInList(Car c){
        return this.getCars().contains(c);
    }
    @Override
    public String toString(){
        return "Brand: "+this.branchNr + " "+ this.address +" "+this.phoneNr;
    }
    @Override
    public boolean equals(Object o){
        if (o == this)
            return  true;
        if (!(o instanceof Branch))
            return false;
        Branch b = (Branch)o;
        return  branchNr.equals(b.branchNr);
    }
    @Override
    public int hashCode(){
        return branchNr.hashCode();
    }
}
