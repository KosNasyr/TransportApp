package ejb;

import model.AllHierarchy;
import model.Management;
import model.PassengerCar;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Singleton
@Startup
public class ConsolePrinterBean {

    @PersistenceContext(unitName = "TestPersistence")
    EntityManager em;

    @PostConstruct
    public void init() {
        try {
            ArrayList<Management> managements = new ArrayList<>();
            ArrayList<PassengerCar> cars = new ArrayList<>();
            List logs = em.createStoredProcedureQuery("transport", "AllHierarchyMapping").getResultList();
            Iterator iterator = logs.iterator();
            System.out.println("========AllHierarchy=========");
            while (iterator.hasNext()) {
                AllHierarchy ah = (AllHierarchy) iterator.next();
//                System.out.println(ah);
                if (ah.getPathLabel().equals("bm")){
                    managements.add( new Management(ah.getBmId(),
                            ah.getBmManager(),
                            ah.getBmAddress()));
                }
                else if (ah.getPathLabel().equals("pc")){
                    cars.add(new PassengerCar(ah.getPcId(),
                            ah.getPcTankAverage(),
                            ah.getPcDriver(),
                            ah.getPcRegistrationPlate()));
                }
            }
            for (Management mn: managements) {
                System.out.println(mn);
            }
            for( PassengerCar pc: cars){
                System.out.println(pc);
            }


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}