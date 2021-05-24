package entity;

import java.util.ArrayList;
import java.util.List;

public class Model {
    String modelNr;
    String description;
    String gearType;
    float petrolConsumption;
    List <Car> cars ;

    public Model() {
    }

    public Model(String modelNr, String description, String gearType, float petrolConsumption) {
        this.modelNr = modelNr;
        this.description = description;
        this.gearType = gearType;
        this.petrolConsumption = petrolConsumption;
        this.cars = new ArrayList<>();
    }

    public String getModelNr() {
        return modelNr;
    }

    public void setModelNr(String modelNr) {
        this.modelNr = modelNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public float getPetrolConsumption() {
        return petrolConsumption;
    }

    public void setPetrolConsumption(float petrolConsumption) {
        this.petrolConsumption = petrolConsumption;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @Override
    public boolean equals(Object o){
        if (o==this)
            return  true;
        if(!(o instanceof Model))
            return  false;
        Model model = (Model)o;
        return  this.modelNr.equals(model.modelNr);
    }
    @Override
    public int hashCode(){
        return this.modelNr.hashCode();
    }

}
