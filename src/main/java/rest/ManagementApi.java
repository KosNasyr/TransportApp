package rest;

import ejb.ManagementBean;
import model.jpa.Management;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("management")
public class ManagementApi {
    @EJB
    ManagementBean managementBean;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Management getManagement(@PathParam("id") int id) throws NotFoundException {
        Management management = managementBean.getManagement(id);
        return management;
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addManager(Management man){
        managementBean.createNewManagement(man);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editManagement(Management man){
        managementBean.updateManagement(man);
    }

    @DELETE
    @Path("{id}")
    public void deleteManagement(@PathParam("id") int id) throws NotFoundException {
        managementBean.deleteManagement(id);
    }

}
