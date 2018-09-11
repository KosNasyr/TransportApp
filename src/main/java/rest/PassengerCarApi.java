package rest;

import ejb.PassengerCarBean;
import model.jpa.PassengerCar;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("passengercar")
public class PassengerCarApi {
    @EJB
    PassengerCarBean passengerCarBean;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PassengerCar getPassengerCar(@PathParam("id") int id) throws NotFoundException{
        PassengerCar pc = passengerCarBean.getPassengerCar(id);
        return pc;
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPassengerCar(PassengerCar pc){
        passengerCarBean.createNewPC(pc);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editPassengerCar(PassengerCar pc){
        passengerCarBean.updatePassengerCar(pc);
    }

    @DELETE
    @Path("{id}")
    public void deletePassengerCar(@PathParam("id") int id) throws NotFoundException {
        passengerCarBean.deletePassengerCar(id);
    }
}
