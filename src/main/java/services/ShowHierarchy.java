package services;

import ejb.GetAllHierarchyBean;
import model.busines.Htree;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hierarchy")
public class ShowHierarchy {

    @EJB
    GetAllHierarchyBean allHierarchyBean;

    @Path("tree")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Htree getHierarchy() {
        Htree tree = allHierarchyBean.getTree();
        return tree;
    }
}