package ejb;

import model.jpa.Management;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ManagementBean {
    @PersistenceContext(unitName = "XoPersistence")
    private EntityManager em;

    public void createNewManagement(Management man){
        Query q = em.createNamedQuery("add_manager")
                .setParameter(1,man.getManager())
                .setParameter(2,man.getAddress());
        q.getSingleResult();
    }

    public Management getManagement(int id){
        Management man = em.find(Management.class,id);
        return man;
    }

    public void updateManagement(Management man) {
        em.merge(man);
        em.flush();
    }
    public void deleteManagement(int id){

        Query q = em.createNamedQuery("del_manager")
                .setParameter(1,id);
        q.getSingleResult();
    }

}
