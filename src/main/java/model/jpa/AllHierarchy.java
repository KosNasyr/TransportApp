package model.jpa;


import javax.persistence.*;
import java.io.Serializable;


@SqlResultSetMapping(
        name = "AllHierarchyMapping",
        entities = {
                @EntityResult(
                        entityClass = AllHierarchy.class,
                        fields = {
                                @FieldResult( name = "id", column = "ch_id"),
                                @FieldResult( name = "hierarchy", column = "ch_path"),
                                @FieldResult( name = "bmId", column = "bm_id"),
                                @FieldResult( name = "bmManager", column = "bm_manager"),
                                @FieldResult( name = "bmAddress", column = "bm_address"),

                                @FieldResult( name = "trId", column = "tr_id"),
                                @FieldResult( name = "trTankAverage", column = "tr_tank_average"),
                                @FieldResult( name = "trCargo", column = "tr_cargo"),
                                @FieldResult( name = "trDriver", column = "tr_driver"),
                                @FieldResult( name = "trRegistrationPlate", column = "tr_reg_plate"),

                                @FieldResult( name = "bsId", column = "bs_id"),
                                @FieldResult( name = "bsTankAverage", column = "bs_tank_average"),
                                @FieldResult( name = "bsCapacity", column = "bs_capacity"),
                                @FieldResult( name = "bsDriver", column = "bs_driver"),
                                @FieldResult( name = "bsRegistrationPlate", column = "bs_reg_plate"),

                                @FieldResult( name = "pcId", column = "pc_id"),
                                @FieldResult( name = "pcTankAverage", column = "pc_tank_average"),
                                @FieldResult( name = "pcDriver", column = "pc_driver"),
                                @FieldResult( name = "pcRegistrationPlate", column = "pc_reg_plate"),

                                @FieldResult( name = "pathLabel", column = "pl")

                        })})

@Entity
public class AllHierarchy implements Serializable {

    public AllHierarchy(){
    }

    @Id
    private int id;
    private String hierarchy;

    private int bmId;
    private String bmManager;
    private String bmAddress;

    private int trId;
    private double trTankAverage;
    private String trCargo;
    private String trDriver;
    private String trRegistrationPlate;

    private int bsId;
    private double bsTankAverage;
    private int bsCapacity;
    private String bsDriver;
    private String bsRegistrationPlate;

    private int pcId;
    private double pcTankAverage;
    private String pcDriver;
    private String pcRegistrationPlate;

    private String pathLabel;

    public AllHierarchy(String hierarchy, int bmId, String bmManager, String bmAddress,
                        int trId, double trTankAverage, String trCargo, String trDriver, String trRegistrationPlate,
                        int bsId, double bsTankAverage, int bsCapacity, String bsDriver, String bsRegistrationPlate,
                        int pcId, double pcTankAverage, String pcDriver, String pcRegistrationPlate, String pathLabel) {
        this.hierarchy = hierarchy;
        this.bmId = bmId;
        this.bmManager = bmManager;
        this.bmAddress = bmAddress;
        this.trId = trId;
        this.trTankAverage = trTankAverage;
        this.trCargo = trCargo;
        this.trDriver = trDriver;
        this.trRegistrationPlate = trRegistrationPlate;
        this.bsId = bsId;
        this.bsTankAverage = bsTankAverage;
        this.bsCapacity = bsCapacity;
        this.bsDriver = bsDriver;
        this.bsRegistrationPlate = bsRegistrationPlate;
        this.pcId = pcId;
        this.pcTankAverage = pcTankAverage;
        this.pcDriver = pcDriver;
        this.pcRegistrationPlate = pcRegistrationPlate;
        this.pathLabel = pathLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public int getBmId() {
        return bmId;
    }

    public void setBmId(int bmId) {
        this.bmId = bmId;
    }

    public String getBmManager() {
        return bmManager;
    }

    public void setBmManager(String bmManager) {
        this.bmManager = bmManager;
    }

    public String getBmAddress() {
        return bmAddress;
    }

    public void setBmAddress(String bmAddress) {
        this.bmAddress = bmAddress;
    }

    public int getTrId() {
        return trId;
    }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    public double getTrTankAverage() {
        return trTankAverage;
    }

    public void setTrTankAverage(double trTankAverage) {
        this.trTankAverage = trTankAverage;
    }

    public String getTrCargo() {
        return trCargo;
    }

    public void setTrCargo(String trCargo) {
        this.trCargo = trCargo;
    }

    public String getTrDriver() {
        return trDriver;
    }

    public void setTrDriver(String trDriver) {
        this.trDriver = trDriver;
    }

    public String getTrRegistrationPlate() {
        return trRegistrationPlate;
    }

    public void setTrRegistrationPlate(String trRegistrationPlate) {
        this.trRegistrationPlate = trRegistrationPlate;
    }

    public int getBsId() {
        return bsId;
    }

    public void setBsId(int bsId) {
        this.bsId = bsId;
    }

    public double getBsTankAverage() {
        return bsTankAverage;
    }

    public void setBsTankAverage(double bsTankAverage) {
        this.bsTankAverage = bsTankAverage;
    }

    public int getBsCapacity() {
        return bsCapacity;
    }

    public void setBsCapacity(int bsCapacity) {
        this.bsCapacity = bsCapacity;
    }

    public String getBsDriver() {
        return bsDriver;
    }

    public void setBsDriver(String bsDriver) {
        this.bsDriver = bsDriver;
    }

    public String getBsRegistrationPlate() {
        return bsRegistrationPlate;
    }

    public void setBsRegistrationPlate(String bsRegistrationPlate) {
        this.bsRegistrationPlate = bsRegistrationPlate;
    }

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public double getPcTankAverage() {
        return pcTankAverage;
    }

    public void setPcTankAverage(double pcTankAverage) {
        this.pcTankAverage = pcTankAverage;
    }

    public String getPcDriver() {
        return pcDriver;
    }

    public void setPcDriver(String pcDriver) {
        this.pcDriver = pcDriver;
    }

    public String getPcRegistrationPlate() {
        return pcRegistrationPlate;
    }

    public void setPcRegistrationPlate(String pcRegistrationPlate) {
        this.pcRegistrationPlate = pcRegistrationPlate;
    }

    public String getPathLabel() {
        return pathLabel;
    }

    public void setPathLabel(String pathLabel) {
        this.pathLabel = pathLabel;
    }

    @Override
    public String toString() {
        return ""+getId() +"|" +  getHierarchy()+"|" + getBmId() +"|"+ getBmManager() +"|"+ getBmAddress() +"|"+
                getTrId() +"|"+ getTrTankAverage() +"|"+ getTrCargo() +"|"+ getTrDriver() +"|"+ getTrRegistrationPlate() +"|"+
                getBsId() +"|"+ getBsTankAverage() +"|"+ getBsCapacity() +"|"+ getBsDriver() +"|"+ getBsRegistrationPlate() +"|"+
                getPcId() +"|"+ getPcTankAverage() +"|"+ getPcDriver() +"|"+ getPcRegistrationPlate() +"|"+ getPathLabel();
    }


}