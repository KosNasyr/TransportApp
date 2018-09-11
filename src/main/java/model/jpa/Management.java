package model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="branch_management")
public class Management extends HierarchyObject{

    @Column(name= "manager")
    private String manager;

    @Column(name = "address")
    private String address;

    public Management(){
    }

    public Management(String manager, String address){
        this.manager = manager;
        this.address = address;
    }

    public Management(int id, String manager, String address){
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
        return "" +getId() +"|" +getManager() + "|" + getAddress() ;
    }
}
