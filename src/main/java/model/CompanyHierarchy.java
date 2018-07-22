package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="company_hierarcy")
public class CompanyHierarchy extends HierarchyObject {
    @Column(name ="path", columnDefinition="ltree")
    private String hierarchy;

    public CompanyHierarchy(){
    }

    public  CompanyHierarchy(int id, String hierarchy){
        super(id);
        this.hierarchy = hierarchy;
    }

    public String getHierarcy() {
        return hierarchy;
    }

    public void setHierarcy(String hierarcy) {
        this.hierarchy = hierarcy;
    }

    @Override
    public String toString() {
        return ""+getId() +"/" +  getHierarcy();
    }
}