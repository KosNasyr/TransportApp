package ejb;

import model.jpa.PassengerCar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PassengerCarBean {
    @PersistenceContext(unitName = "XoPersistence")
    private EntityManager em;

    public void createNewPC(PassengerCar pc){
        Query q = em.createNamedQuery("add_passengercar")
                    .setParameter(1,pc.getId())
                    .setParameter(2,pc.getTankAverage())
                    .setParameter(3,pc.getDriver())
                    .setParameter(4,pc.getRegistrationPlate());
        q.getSingleResult();
    }

    public PassengerCar getPassengerCar(int id){
        PassengerCar pc = em.find(PassengerCar.class,id);
        return pc;
    }

    public void updatePassengerCar(PassengerCar pc) {
        em.merge(pc);
        em.flush();
    }

    public void deletePassengerCar(int id){
        Query q = em.createNamedQuery("del_passengercar")
                .setParameter(1,id);
        q.getSingleResult();
    }

}
