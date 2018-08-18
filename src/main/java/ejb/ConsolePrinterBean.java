package ejb;

import model.busines.HierarchyObjectNode;
import model.busines.Htree;
import model.busines.Management;
import model.busines.PassengerCar;

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

        Htree tree = getAll.getTree();
        HierarchyObjectNode root = tree.getRootElement();
        System.out.println("---------------------ConsolePrintBean---------------------");
        System.out.println(root);

        System.out.println(root.getNumberOfChildren());
        System.out.println(root.getChildren().get(0));
        System.out.println( "root 10th children = " + root.getChildren().get(9) + ";   class = " + root.getChildren().get(9).getClass());
        System.out.println(root.getChildren().get(0).getNumberOfChildren());
        System.out.println(root.getChildren().get(0).getChildren().get(0));
        System.out.println("---------------------AllTree---------------------");
        System.out.println(tree);


    }


}
