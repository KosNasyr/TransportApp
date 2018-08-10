package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejb.GetAllHierarchyBean;
import model.Tree;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hierarchy")
public class ShowHierarchy {

    @EJB
    GetAllHierarchyBean allHierarchyBean;

    @Path("get")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHierarchy() {
        String treeToJson = "";
        Tree tree = allHierarchyBean.getTree();
        ObjectMapper mapper = new ObjectMapper();
        try {
            treeToJson = mapper.writeValueAsString(tree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "<h3> Company Hierarchy : " + treeToJson + "</h3>";
    }
}