package ejb;

import model.busines.*;
import model.jpa.AllHierarchy;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Singleton
@Startup
public class GetAllHierarchyBean {

    @PersistenceContext(unitName = "TestPersistence")
    EntityManager em;

    public Htree getTree() {
        Htree allHierarchyTree = new Htree();
        try {
            ArrayList<AllHierarchy> allHierarchies = (ArrayList<AllHierarchy>) em.createStoredProcedureQuery("transport", "AllHierarchyMapping").getResultList();
            System.out.println("========AllHierarchy=========");

            Management root = new Management(allHierarchies.get(0).getBmId(),
                    HierarchyType.MANAGEMENT,
                    allHierarchies.get(0).getBmManager(),
                    allHierarchies.get(0).getBmAddress());
            allHierarchyTree.setRootElement(root);
            for (AllHierarchy ah3: allHierarchies) {
                if (ah3.getPathLabel().equals("bm") & ah3.getBmId() > 1){
                    root.addChild(new Management(ah3.getBmId(),
                            HierarchyType.MANAGEMENT,
                            ah3.getBmManager(),ah3.getBmAddress()));
                }
                else if (ah3.getHierarchy().length() ==7) {
                    if (ah3.getPathLabel().equals("pc")) {
                        root.addChild(new PassengerCar(ah3.getPcId(),
                                HierarchyType.PASSENGER_CAR,
                                ah3.getPcTankAverage(),
                                ah3.getPcDriver(),
                                ah3.getPcRegistrationPlate()));
                    }
                    else if (ah3.getPathLabel().equals("bs")) {
                        root.addChild(new Bus(ah3.getBsId(),
                                HierarchyType.BUS,
                                ah3.getBsTankAverage(),
                                ah3.getBsCapacity(),
                                ah3.getBsDriver(),
                                ah3.getBsRegistrationPlate()));
                    }
                    else if (ah3.getPathLabel().equals("tr")) {
                        root.addChild(new Truck(ah3.getTrId(),
                                HierarchyType.TRUCK,
                                ah3.getTrTankAverage(),
                                ah3.getTrCargo(),
                                ah3.getTrDriver(),
                                ah3.getTrRegistrationPlate()));
                    }
                }
                else if (ah3.getHierarchy().length() > 7) {
                    if (ah3.getHierarchy().substring(6, 7).equals("2")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(0).addChild(new PassengerCar(ah3.getPcId(),
                                    HierarchyType.PASSENGER_CAR,
                                    ah3.getPcTankAverage(),
                                    ah3.getPcDriver(),
                                    ah3.getPcRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(0).addChild(new Bus(ah3.getBsId(),
                                    HierarchyType.BUS,
                                    ah3.getBsTankAverage(),
                                    ah3.getBsCapacity(),
                                    ah3.getBsDriver(),
                                    ah3.getBsRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(0).addChild(new Truck(ah3.getTrId(),
                                    HierarchyType.TRUCK,
                                    ah3.getTrTankAverage(),
                                    ah3.getTrCargo(),
                                    ah3.getTrDriver(),
                                    ah3.getTrRegistrationPlate()));
                        }
                    }
                    else if (ah3.getHierarchy().substring(6, 7).equals("3")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(1).addChild(new PassengerCar(ah3.getPcId(),
                                    HierarchyType.PASSENGER_CAR,
                                    ah3.getPcTankAverage(),
                                    ah3.getPcDriver(),
                                    ah3.getPcRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(1).addChild(new Bus(ah3.getBsId(),
                                    HierarchyType.BUS,
                                    ah3.getBsTankAverage(),
                                    ah3.getBsCapacity(),
                                    ah3.getBsDriver(),
                                    ah3.getBsRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(1).addChild(new Truck(ah3.getTrId(),
                                    HierarchyType.TRUCK,
                                    ah3.getTrTankAverage(),
                                    ah3.getTrCargo(),
                                    ah3.getTrDriver(),
                                    ah3.getTrRegistrationPlate()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========AllHierarchyDone=========");
        return allHierarchyTree;
    }
}