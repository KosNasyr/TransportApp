package model.busines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class HierarchyObjectNode implements Serializable {

    private int id;

    private HierarchyType type;

    public HierarchyObjectNode() {
    }

    public HierarchyObjectNode(int id, HierarchyType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HierarchyType getType() {
        return type;
    }

    public void setType(HierarchyType type) {
        this.type = type;
    }

    public List<HierarchyObjectNode> children;

    public List<HierarchyObjectNode> getChildren() {
        if (this.children == null) {
            return new ArrayList<HierarchyObjectNode>();
        }
        return this.children;
    }

    public void setChildren(List<HierarchyObjectNode> children) {
        this.children = children;
    }

    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    public void addChild(HierarchyObjectNode child) {
        if (children == null) {
            children = new ArrayList<HierarchyObjectNode>();
        }
        children.add(child);
    }

    public void insertChildAt(int index, HierarchyObjectNode child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            addChild(child);
            return;
        } else {
            children.get(index);
            children.add(index, child);
        }
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }
}
