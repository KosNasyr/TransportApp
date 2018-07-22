package model;

public class Vehicle extends HierarchyObject {
    private double tankAverage;
    private String registrationPlate;
    private String driver;

    public Vehicle(){
    }

    public Vehicle(int id,double tankAverage, String  registrationPlate,  String driver){
        super(id);
        this.tankAverage= tankAverage;
        this.registrationPlate = registrationPlate;
        this.driver = driver;
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