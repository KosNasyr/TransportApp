package model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus extends Vehicle{
    @Column(name = "capacity")
    private int capacity;

    public Bus(){
    }

    public Bus(double tankAverage, int capacity, String  registrationPlate, String driver){
        super (tankAverage, registrationPlate, driver);
        this.capacity = capacity;
    }

    public Bus(int id, double tankAverage, int capacity, String  registrationPlate, String driver){
        super (id,tankAverage, registrationPlate, driver);
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
