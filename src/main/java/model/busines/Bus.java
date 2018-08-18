package model.busines;

public class Bus extends Vehicle {
    private int capacity;

    public Bus(){
    }

    public Bus(int id, HierarchyType type, double tankAverage, int capacity, String  registrationPlate, String driver){
        super (id, type,tankAverage, registrationPlate, driver);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return ""+getId() +"|" + getTankAverage() +"|" + getCapacity() +"|"  + getDriver() +"|" + getRegistrationPlate();
    }
}