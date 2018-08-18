package model.busines;

public class Truck extends Vehicle {
    private String cargo;

    public Truck(){
    }

    public Truck(int id, HierarchyType type, double tankAverage, String cargo, String registrationPlate, String driver){
        super (id, type, tankAverage, registrationPlate, driver);
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