package rest;

import ejb.TruckBean;
import model.jpa.Truck;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("truck")
public class TruckApi {
    @EJB
    TruckBean truckBean;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Truck getTruck(@PathParam("id") int id) throws NotFoundException {
        Truck truck = truckBean.getTruck(id);
        return truck;
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTruck(Truck truck){
        truckBean.createNewTruck(truck);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editTruck(Truck truck){
        truckBean.updateTruck(truck);
    }

    @DELETE
    @Path("{id}")
    public void deleteTruck(@PathParam("id") int id) throws NotFoundException {
        truckBean.deleteTruck(id);
    }

}
