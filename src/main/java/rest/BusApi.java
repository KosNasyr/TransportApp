package rest;

import ejb.BusBean;
import model.jpa.Bus;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("bus")
public class BusApi {
    @EJB
    BusBean busBean;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bus getBus(@PathParam("id") int id) throws NotFoundException {
        Bus bus = busBean.getBus(id);
        return bus;
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBus(Bus bus){
        busBean.createNewBus(bus);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editBus(Bus bus){
        busBean.updateBus(bus);
    }

    @DELETE
    @Path("{id}")
    public void deleteBus(@PathParam("id") int id) throws NotFoundException {
        busBean.deleteBus(id);
    }

}

