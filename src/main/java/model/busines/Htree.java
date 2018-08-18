package model.busines;

import java.util.ArrayList;
import java.util.List;

public class Htree {
    private HierarchyObjectNode rootElement;

    public Htree() {
        super();
    }

    public HierarchyObjectNode getRootElement() {
        return this.rootElement;
    }

    public void setRootElement(HierarchyObjectNode rootElement) {
        this.rootElement = rootElement;
    }

    public List<HierarchyObjectNode> toList() {
        List<HierarchyObjectNode> list = new ArrayList<>();
        walk(rootElement, list);
        return list;
    }

    private void walk(HierarchyObjectNode element, List<HierarchyObjectNode> list) {
        list.add(element);
        for (HierarchyObjectNode data : element.getChildren()) {
            walk(data, list);
        }
    }

    @Override
    public String toString() {

        return  "Tree =  " + " Root "+ rootElement + "\n" +
                "  Root Children "  + rootElement.getChildren() + "\n" +
                " 1st Children  " + rootElement.getChildren().get(0).getChildren() + "\n" +
                " 2nd Children  " + rootElement.getChildren().get(1).getChildren();
    }

}

