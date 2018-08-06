package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle extends HierarchyObject {

    @Column(name = "tank_average")
    private double tankAverage;
    @Column(name = "driver")
    private String driver;
    @Column(name = "registration_plate")
    private String registrationPlate;

    public Vehicle(){
    }

    public Vehicle(int id,double tankAverage, String driver, String  registrationPlate){
        super(id);
        this.tankAverage= tankAverage;
        this.driver = driver;
        this.registrationPlate = registrationPlate;
    }


    public double getTankAverage() {
        return tankAverage;
    }

    public void setTankAverage(double tankAverage) {
        this.tankAverage = tankAverage;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}