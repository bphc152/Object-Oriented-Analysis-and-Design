package entity;

import java.util.HashSet;
import java.util.Set;

public class RentalGroup {
    String code;
    String description;
    float dailyRentalRate;
    Set<Model> models;

    public RentalGroup() {
    }

    public RentalGroup(String code, String description, float dailyRentalRate) {
        this.code = code;
        this.description = description;
        this.dailyRentalRate = dailyRentalRate;
        this.models = new HashSet<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDailyRentalRate() {
        return dailyRentalRate;
    }

    public void setDailyRentalRate(float dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if (!(o instanceof RentalGroup))
            return false;
        RentalGroup rentalGroup = (RentalGroup)o;
        return this.code.equals(rentalGroup.code);
    }
    @Override
    public int hashCode(){
        return this.code.hashCode();
    }
}
