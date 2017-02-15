/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly.developer.boundary;

import io.droidme.fly.developer.entity.Developer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 * @author droidme
 */
@Path("developers")
@Produces(APPLICATION_JSON)
public class DevelopersResource {
    
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<Developer> getDevelopers() {
        
        List<Developer> developers = em
                .createNamedQuery(Developer.FIND_ALL, Developer.class).getResultList();
        
        return developers;
    }
    
    @GET
    @Path("{id}")
    public String getDeveloper(@PathParam("id") int id) {
        return "gathering Developer with id + " + id;
    }
    
}
