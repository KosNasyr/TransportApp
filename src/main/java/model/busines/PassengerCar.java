package model.busines;


public class PassengerCar extends Vehicle {
    public PassengerCar(){
    }

    public PassengerCar(int id, HierarchyType type, double tankAverage, String driver, String  registrationPlate){
        super(id,type,tankAverage,driver,registrationPlate);
    }

    @Override
    public String toString() {
        return ""+getId() +"|" +  getTankAverage() +"|" + getDriver() +"|"+getRegistrationPlate() ;
    }


}