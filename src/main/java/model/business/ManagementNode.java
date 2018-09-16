package model.business;

public class ManagementNode extends HierarchyObjectNode {

    private String manager;

    private String address;

    public ManagementNode(){
    }

    public ManagementNode(String manager, String address){
        this.manager = manager;
        this.address = address;
    }

    public ManagementNode(int id, HierarchyType type, String manager, String address){
        super(id, type);
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
        return ""+getId() +"|" + getType() +"|" +getManager() + "|" + getAddress() ;
    }
}