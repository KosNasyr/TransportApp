package ejb;

import model.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;

@Singleton
@Startup
public class ConsolePrinterBean {
    @EJB
    GetAllHierarchyBean getAll;

    @PostConstruct
    public void consolePrint(){
        ArrayList<Management> managements = new ArrayList<>();
        ArrayList<PassengerCar> cars = new ArrayList<>();

        Tree tree = getAll.getTree();
        Node <AllHierarchy> root = tree.getRootElement();
        System.out.println("---------------------ConsolePrintBean---------------------");
        System.out.println(root.getChildren());
        System.out.println(root.getChildren().get(0).getChildren());
        System.out.println(root.getChildren().get(1).getChildren());

        AllHierarchy mainManager = root.getData();
        managements.add( new Management(mainManager.getBmId(),
                mainManager.getBmManager(),
                mainManager.getBmAddress()));
        for (int i =0; i<root.getChildren().size(); i++){
            AllHierarchy ah2=  root.getChildren().get(i).getData();
            System.out.println("i  "+ i + " Data  "+ ah2);
            if (ah2.getPathLabel().equals("bm")){
                managements.add( new Management(ah2.getBmId(),
                        ah2.getBmManager(),
                        ah2.getBmAddress()));
            }
        }
        for (Management mn: managements){
            System.out.println(mn);
        }

    }


}
