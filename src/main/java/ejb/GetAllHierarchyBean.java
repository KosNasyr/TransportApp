package ejb;

import model.*;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Singleton
@Startup
public class GetAllHierarchyBean {

    @PersistenceContext(unitName = "TestPersistence")
    EntityManager em;

    public Tree getTree() {
        Tree <AllHierarchy> allHierarchyTree = new Tree();
        try {
            ArrayList<AllHierarchy> allHierarchies = new ArrayList<>();
            List logs = em.createStoredProcedureQuery("transport", "AllHierarchyMapping").getResultList();
            Iterator iterator = logs.iterator();
            System.out.println("========AllHierarchy=========");
            while (iterator.hasNext()) {
                AllHierarchy ah = (AllHierarchy) iterator.next();
                allHierarchies.add(ah);
            }

            Node<AllHierarchy> root = new Node<>(allHierarchies.get(0));
            allHierarchyTree.setRootElement(root);
            for (AllHierarchy ah3: allHierarchies) {
                if (ah3.getPathLabel().equals("bm") & ah3.getBmId() > 1){
                    root.addChild(new Node<>(ah3));
                }
                else if (ah3.getHierarchy().length() ==7) {
                    if (ah3.getPathLabel().equals("pc")) {
                        root.addChild(new Node<>(ah3));
                    }
                    else if (ah3.getPathLabel().equals("bs")) {
                        root.addChild(new Node<>(ah3));
                    }
                    else if (ah3.getPathLabel().equals("tr")) {
                        root.addChild(new Node<>(ah3));
                    }
                }
                else if (ah3.getHierarchy().length() > 7) {
                    if (ah3.getHierarchy().substring(6, 7).equals("2")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(0).addChild(new Node<>(ah3));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(0).addChild(new Node<>(ah3));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(0).addChild(new Node<>(ah3));
                        }
                    }
                    else if (ah3.getHierarchy().substring(6, 7).equals("3")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(1).addChild(new Node<>(ah3));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(1).addChild(new Node<>(ah3));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(1).addChild(new Node<>(ah3));
                        }
                    }
                }
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("========AllHierarchyDone=========");
        return allHierarchyTree;

//        try {
//            List pcs = em.createQuery("FROM PassengerCar ").getResultList();
//            Iterator iterator = pcs.iterator();
//            System.out.println("========PCS=========");
//            while (iterator.hasNext()) {
//                PassengerCar pc = (PassengerCar) iterator.next();
//                System.out.println(pc);
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
    }
}