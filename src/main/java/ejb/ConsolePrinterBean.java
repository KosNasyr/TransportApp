package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConsolePrinterBean {

    @PostConstruct
    public void consolePrint(){
        System.out.println(" Transport application ");
    }

}
