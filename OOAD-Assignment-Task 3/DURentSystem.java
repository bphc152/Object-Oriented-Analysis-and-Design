package main;

import entity.*;
import globalVariable.GC;

import java.util.*;

public class DURentSystem {
    Set <Customer> customers;
    Set <Car> vehicleList;
    Set <Model> modelList;
    Set <Branch> branchList;
    Set <RentalGroup> rentalGroupList;
    Set <Rental> rentalList;
    Set <WalkInRental> walkInRentalList;
    Set <ReservationRental> reservationRentalList;

    public DURentSystem() {
        this.customers= new HashSet<>();
        this.vehicleList= new HashSet<>();
        this.modelList = new HashSet<>();
        this.branchList = new HashSet<>();
        this.rentalGroupList = new HashSet<>();
        this.rentalList = new HashSet<>();
        this.walkInRentalList = new HashSet<>();
        this.reservationRentalList = new HashSet<>();
    }

    //* add a new branch
    public boolean addBranch(String branchNr,String address,String phoneNr){
        Branch b = new Branch(branchNr,address,phoneNr);
        if(this.branchList.contains(b)){
            return false;
        }
        this.branchList.add(b);
        return true;
    }

    //* Make a pair of branches neighbors to each other
    public boolean setNeighbors(String a, String b){
        if (a.equals(b)){
            return false;
        }
        if(getBranchFromBranchNr(a)==null){
            return false;
        }
        if(getBranchFromBranchNr(b)==null){
            return false;
        }
        // A -> neighbor [b]
        // B -> neighbor [a]
        Branch branchA = getBranchFromBranchNr(a);
        Branch branchB = getBranchFromBranchNr(b);
        branchA.getNeigbor().add(branchB);
        branchB.getNeigbor().add(branchA);
        return true;
    }

    //*	Add a car rental group
    public boolean addRentalGroup(String code,String description,float dailyRentalRate){
        RentalGroup rentalGroup = new RentalGroup(code,description,dailyRentalRate);
        if (rentalGroupList.contains(rentalGroup)){
            return false;
        }
        this.rentalGroupList.add(rentalGroup);
        return true;
    }

    //* Add a model
    public boolean addModel(String modelNr, String description, String gearType,String code){
        Model model = new Model(modelNr,description,gearType, (float) 1.5);
        RentalGroup rentalGroup = getRentalGroupFromCode(code);
        if(rentalGroup == null){
            System.out.println("Not exist rental group with this code!");
            return false;
        }
        if (this.modelList.contains(model)){
            System.out.println("Exist model!");
            return false;
        }
        rentalGroup.getModels().add(model);
        this.modelList.add(model);
        return true;
    }

    //* Add a Car ---
    public boolean addCar(String regNr,String modelNr,String branchNr){
        Car car = new Car(regNr);
        Branch branch = getBranchFromBranchNr(branchNr);
        Model model = getModelFromModelNr(modelNr);
        if(this.vehicleList.contains(car)){
            System.out.println("Exist car");
            return  false;
        }
        if(branch == null){
            System.out.println("Not exist Branch!");
            return  false;
        }
        if(model == null){
            System.out.println("Not exist Model!");
            return false;
        }
        this.vehicleList.add(car);
        branch.getCars().add(car);
        model.getCars().add(car);
        return  true;
    }

    //* Add a customer
    public boolean addCustomer(String licenseNr,String name,String phoneNr,boolean discount,boolean blacklist) {
        Customer c = new Customer(licenseNr,name,phoneNr,discount,blacklist);
        if(this.customers.contains(c))
            return false;
        this.customers.add(c);
        return true;
    }
    //* List car that available at a specified branch and belong to a specified rental group(do not include car neighbor)
    public boolean getAvailableCar(String branchNr, String code){
        Set <Car> carsAvailable = new HashSet<>();
        Branch branch = getBranchFromBranchNr(branchNr);
        RentalGroup rentalGroup = getRentalGroupFromCode(code);
        if(branch==null){
            System.out.println("Not exist branch with this branchNr");
            return false;
        }
        if(rentalGroup==null){
            System.out.println("Not exist rental group with this code");
            return false;
        }
        Set <Model> models = rentalGroup.getModels();
        List <Car> carList = branch.getCars();
        for(Car c: carList){
            if(c.getStatus().equals(GC.AVAILABLE)){
                carsAvailable.add(c);
            }
        }
        System.out.println("----List car:");
        for(Model m : models){
            List<Car> carList1 = m.getCars();
            for(Car c : carList1){
                if(carsAvailable.contains(c)){
                    System.out.println(branchNr + "-" +code + ": "+c);
                }
            }
        }
        System.out.println("--------------");
        return true;
    }
    //* List cars that are available at the neighbor branches of a specified branch and belong to a specified rental group
    public boolean getAvailableCarFromNeighbor(String branchNr,String code){
        Set<Car> carAvailableNeighbor = new HashSet<>();
        Branch branch = getBranchFromBranchNr(branchNr);
        RentalGroup rentalGroup = getRentalGroupFromCode(code);
        if(branch==null){
            System.out.println("Not exist branch with this branchNr");
            return false;
        }
        if(rentalGroup == null){
            System.out.println("Not exist rental group with this branchNr");
            return false;
        }
        Set <Model> models = rentalGroup.getModels();
        Set <Branch> branchNeighbor = branch.getNeigbor();
        System.out.println("----List car available form neighbor----");
        for (Branch neigh : branchNeighbor){
            System.out.println("-----"+neigh.getBranchNr()+"-----");
            List <Car> carList = neigh.getCars();
            for(Car c : carList){
                if(c.getStatus().equals(GC.AVAILABLE)){
                    carAvailableNeighbor.add(c);
                }
            }
            for(Model m:models){
                List<Car> carList1 = m.getCars();
                for(Car c : carList1){
                    if(carAvailableNeighbor.contains(c)){
                        System.out.println(branchNr + "-" +code + ": "+c);
                    }
                }
            }
        }
        System.out.println("--------------------------------------");
        return true;
    }
    //* Enter a walk-in rental paid by cash
    //* Input rentNR, pickUpDay, returnDay, license, regNr,branchNr, payment,note
    public boolean addWalkInRental(String rentNr,int pickUpDay,int returnDay,String license,String regNr,String branchNr, int paymentMethod, String note){
        Rental rental = getRentalFromRentNr(rentNr);
        Branch branch = getBranchFromBranchNr(branchNr);
        Customer customer = getCustomerFromLicense(license);
        Car car = getCarFromRegNr(regNr);
        //check rental
        if(rental != null){
            System.out.println("Exist this rent number");
            return false;
        }
        //check brand
        if(branch==null){
            System.out.println("Not exist this branch: "+branchNr);
            return  false;
        }
        //check customer
        if(customer==null){
            System.out.println("Not exist this customer: "+license);
            return false;
        }
        //check car
        if(car == null){
            System.out.println("Not exist this car: "+regNr);
            return false;
        }
        //check car available in branch
        if(!branch.getCars().contains(car)){
            System.out.println("Not exist car: "+car +" in branch: "+branch);
            return false;
        }
        //create rental
        Rental mainRental = new Rental(rentNr,pickUpDay,returnDay,note);
        //create payment
        Payment payment = new Payment(regNr,1,paymentMethod,"",pickUpDay);
        //create walkInRental
        WalkInRental walkInRental = new WalkInRental(regNr,"",payment);
        //*add to attribute
        car.getRentalList().add(mainRental);
        mainRental.setWalkInRental(walkInRental);

        //*add to list rental
        this.rentalList.add(mainRental);
        this.walkInRentalList.add(walkInRental);
        //*update status car
        car.setStatus(GC.PICKED_UP);
        return true;
    }

    //*record car return
    //*input: rentNr, dayReturn, branchNr
    public boolean recordCarReturn(String rentNr,int dayReturn,String branchNr){
        Rental rental = getRentalFromRentNr(rentNr);
        Branch branch = getBranchFromBranchNr(branchNr);
        //check
        if(rental==null){
            System.out.println("This rental is not found!");
            return false;
        }
        if(branch == null){
            System.out.println("Not exist this branch: "+branchNr);
            return false;
        }
        //get car from rentNr
        Car car = getCarFromRentNr(rentNr);
        Branch branch1 = getBranchFromCar(car);
        if(car == null){
            System.out.println("Something went wrongs");
            return false;
        }
        if(branch1==null){
            System.out.println("Something went wrongs");
            return false;
        }
        //process
        car.setStatus(GC.AVAILABLE);
        if(!branch.equals(branch1)){
            branch.getCars().add(car);
            branch1.getCars().remove(car);
        }

        return true;
    }

    //! GET FUNCTION
    public Branch getBranchFromBranchNr(String branchNr){
        for (Branch b : this.branchList){
            if(b.getBranchNr().equals(branchNr)){
                return b;
            }
        }
        return null;
    }
    public Model getModelFromModelNr(String modelNr){
        for (Model m :this.modelList){
            if(m.getModelNr().equals(modelNr)){
                return m;
            }
        }
        return null;
    }
    public RentalGroup getRentalGroupFromCode(String code){
        for(RentalGroup rentalGroup: this.rentalGroupList){
            if(rentalGroup.getCode().equals(code)){
                return  rentalGroup;
            }
        }
        return null;
    }
    public Customer getCustomerFromLicense(String licenseNr){
        for(Customer customer :this.customers){
            if(customer.getLicenseNr().equals(licenseNr))
                return customer;
        }
        return null;
    }
    public Rental getRentalFromRentNr(String rentNr){
        for(Rental rental :this.rentalList){
            if(rental.getRentalNr().equals(rentNr))
                return rental;
        }
        return null;
    }
    public Car getCarFromRegNr(String regNr){
        for(Car c :this.vehicleList){
            if(c.getRegNr().equals(regNr))
                return c;
        }
        return null;
    }
    public Car getCarFromRentNr(String rentNr){
        for(Car car : this.vehicleList){
            Set<Rental> rentals = car.getRentalList();
            for(Rental rental : rentals){
                if(rental.getRentalNr().equals(rentNr)){
                    return car;
                }
            }
        }
        return null;
    }
    public Branch getBranchFromCar(Car c){
        for (Branch branch:this.branchList){
            if(branch.checkCarInList(c))
                return branch;
        }
        return null;
    }
    //!override
    @Override
    public String toString(){
        //Customer list
        StringBuilder customer=new StringBuilder(" ");
        StringBuilder model = new StringBuilder(" ");
        StringBuilder branch = new StringBuilder(" ");
        StringBuilder rentalGroup=new StringBuilder(" ");
        StringBuilder car = new StringBuilder(" ");
        StringBuilder rental = new StringBuilder(" ");
        for(Customer customer1 : this.customers){
            customer.append(customer1.getLicenseNr());
            customer.append("-");
        }
        for(Car car1 :this.vehicleList){
            car.append(car1.getRegNr());
            car.append("-");
        }
        for(Branch branch1:this.branchList){
            branch.append(branch1.getBranchNr());
            branch.append("-");
        }
        for(Model model1:this.modelList){
            model.append( model1.getModelNr());
            model.append("-");
        }
        for(RentalGroup rentalGroup1 : this.rentalGroupList){
            rentalGroup.append(rentalGroup1.getCode());
            rentalGroup.append("-");
        }
        for(Rental rental1: this.rentalList){
            rental.append(rental1.getRentalNr());
            rental.append("-");
        }
        return "Branch: "+branch+"\n" +
                "Model: "+model+"\n" +
                "RentalGroup: "+rentalGroup+"\n" +
                "Customer: "+customer+"\n" +
                "Car: "+car+"\n" +
                "Rental: "+rental+"\n";
    }
   
}
