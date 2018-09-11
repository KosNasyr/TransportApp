package model.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="passenger_car")
public class PassengerCar extends Vehicle {

    public PassengerCar(){
    }

    public PassengerCar(double tankAverage, String driver, String  registrationPlate){
        super(tankAverage,driver,registrationPlate);
    }

    public PassengerCar(int id, double tankAverage, String driver, String  registrationPlate){
        super(id, tankAverage,driver,registrationPlate);
    }

    @Override
    public String toString() {
        return ""+getId() +"|" +  getTankAverage() +"|" + getDriver() +"|"+getRegistrationPlate() ;
    }
}
