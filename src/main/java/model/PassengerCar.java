package model;

public class PassengerCar extends Vehicle {
    public PassengerCar(){
        super();
    }

    public PassengerCar(int id, double tankAverage, String driver, String  registrationPlate){
        super(id,tankAverage,driver,registrationPlate);
    }

    @Override
    public String toString() {
        return ""+getId() +"|" +  getTankAverage() +"|" + getDriver() +"|"+getRegistrationPlate() ;
    }


}