package ejb;

import model.jpa.Bus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BusBean {
    @PersistenceContext(unitName = "XoPersistence")
    private EntityManager em;

    public void createNewBus(Bus bus){
        Query q = em.createNamedQuery("add_bus")
                .setParameter(1,bus.getId())
                .setParameter(2,bus.getTankAverage())
                .setParameter(3,bus.getCapacity())
                .setParameter(4,bus.getDriver())
                .setParameter(5,bus.getRegistrationPlate());
        q.getSingleResult();
    }

    public Bus getBus(int id){
        Bus bus = em.find(Bus.class,id);
        return bus;
    }

    public void updateBus(Bus bus) {
        em.merge(bus);
        em.flush();
    }

    public void deleteBus(int id){
        Query q = em.createNamedQuery("del_bus")
                .setParameter(1,id);
        q.getSingleResult();
    }
}
