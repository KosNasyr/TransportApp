package model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class HierarchyObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public HierarchyObject() {
    }

    public HierarchyObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
