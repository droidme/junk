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
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author droidme
 */
@Path("developers")
@Produces(APPLICATION_JSON)
public class DevelopersResource {
    
    @PersistenceContext
    EntityManager em;
    
    @Context
    ResourceContext rc;
    
    @GET
    public Response getDevelopers() {
        List<Developer> developers = em
                .createNamedQuery(Developer.FIND_ALL, Developer.class).getResultList();
        if (developers.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok(developers).build();
        }
    }
    
    @Path("{id}")
    public DeveloperResource getDeveloper() {
        return rc.initResource(new DeveloperResource());
    }
    
}
