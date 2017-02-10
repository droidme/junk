/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.simplerest.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author reinh
 */
@Path("echo")
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {
    
    @GET
    public String getMessage(@QueryParam("name") String name) {
        if (name != null) {
            return "Hello ".concat(name);
        }
        return "Hello";
    }
    
}
