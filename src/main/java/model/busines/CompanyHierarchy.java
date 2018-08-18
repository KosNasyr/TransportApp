package model.busines;


public class CompanyHierarchy extends HierarchyObjectNode {

    private String hierarchy;

    public CompanyHierarchy(){
    }

    public CompanyHierarchy(int id, HierarchyType type, String hierarchy){
        super(id, type);
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