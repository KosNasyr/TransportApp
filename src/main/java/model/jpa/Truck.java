package model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="truck")
public class Truck extends Vehicle {

    @Column(name= "cargo")
    private String cargo;

    public Truck(){
    }

    public Truck(double tankAverage, String cargo, String registrationPlate, String driver){
        super (tankAverage, registrationPlate, driver);
        this.cargo=cargo;
    }

    public Truck(int id, double tankAverage, String cargo, String registrationPlate, String driver){
        super (id, tankAverage, registrationPlate, driver);
        this.cargo=cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return ""+getId() +"|"  +  getTankAverage() +"|" + getCargo() +"|"  + getDriver() +"|"  + getRegistrationPlate() ;
    }
}