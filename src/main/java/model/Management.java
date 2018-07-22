package model;

public class Management extends HierarchyObject {
    private String manager;
    private String address;

    public Management(){
    }

    public Management(int id,String manager, String address){
        super(id);
        this.manager = manager;
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ""+getId() +"|"  +getManager() + "|" + getAddress() ;
    }
}