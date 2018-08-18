package services;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("api")
public class Application extends javax.ws.rs.core.Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JacksonFeature.class);
        classes.add(ShowHierarchy.class);
        return classes;
    }
}