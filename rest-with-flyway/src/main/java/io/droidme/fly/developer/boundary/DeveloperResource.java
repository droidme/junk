/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly.developer.boundary;

import io.droidme.fly.developer.entity.Developer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author droidme
 */
public class DeveloperResource {
    
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Produces(APPLICATION_JSON)
    public Response getDeveloper(@PathParam("{id}") int id) {
        Developer developer = em.find(Developer.class, id);
        return Response.ok(developer).build();
    }
    
}
