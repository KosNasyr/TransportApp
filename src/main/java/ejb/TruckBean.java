package ejb;

import model.jpa.Truck;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TruckBean {
    @PersistenceContext(unitName = "XoPersistence")
    private EntityManager em;

    public void createNewTruck(Truck truck){
        Query q = em.createNamedQuery("add_truck")
                .setParameter(1,truck.getId())
                .setParameter(2,truck.getTankAverage())
                .setParameter(3,truck.getCargo())
                .setParameter(4,truck.getDriver())
                .setParameter(5,truck.getRegistrationPlate());
        q.getSingleResult();
    }

    public Truck getTruck(int id){
        Truck truck = em.find(Truck.class,id);
        return truck;
    }

    public void updateTruck(Truck truck) {
        em.merge(truck);
        em.flush();
    }

    public void deleteTruck(int id){
        Query q = em.createNamedQuery("del_truck")
                .setParameter(1,id);
        q.getSingleResult();
    }
}
