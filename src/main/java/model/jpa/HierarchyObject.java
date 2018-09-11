package model.jpa;

import javax.persistence.*;
import java.io.Serializable;


@NamedNativeQueries(
        value= {
                @NamedNativeQuery(
                        name = "add_passengercar",
                        query = "select cast (add_passenger_car(?,?,?,?) as text)"
                ),
                @NamedNativeQuery(
                        name = "del_passengercar",
                        query = "select cast (delete_passenger_car(?) as text)"
                ),
                @NamedNativeQuery(
                        name = "add_bus",
                        query = "select cast (add_bus(?,?,?,?,?) as text)"
                ),
                @NamedNativeQuery(
                        name = "del_bus",
                        query = "select cast (delete_bus(?) as text)"
                ),
                @NamedNativeQuery(
                        name = "add_truck",
                        query = "select cast (add_truck(?,?,?,?,?) as text)"
                ),
                @NamedNativeQuery(
                        name = "del_truck",
                        query = "select cast (delete_truck(?) as text)"
                ),
                @NamedNativeQuery(
                        name = "add_manager",
                        query = "select cast (add_management(?,?) as text)"
                ),
                @NamedNativeQuery(
                        name = "del_manager",
                        query = "select cast (delete_management(?) as text)"
                ),
        }
)

@MappedSuperclass
public class HierarchyObject implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
