package model.busines;

public class PassengerCarNode extends VehicleNode {
    public PassengerCarNode(){
    }

    public PassengerCarNode(double tankAverage, String driver, String  registrationPlate){
        super(tankAverage,driver,registrationPlate);
    }

    public PassengerCarNode(int id, HierarchyType type, double tankAverage, String driver, String  registrationPlate){
        super(id,type,tankAverage,driver,registrationPlate);
    }

    @Override
    public String toString() {
        return ""+getId() +"|" +  getTankAverage() +"|" + getDriver() +"|"+getRegistrationPlate() ;
    }


}