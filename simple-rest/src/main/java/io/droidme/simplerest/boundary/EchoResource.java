/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.simplerest.boundary;

import io.droidme.config.boundary.Property;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author droidme
 */
@Path("echo")
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {
    
    @Inject
    @Property("default.echo")
    String echo;
    
    @Inject
    Boolean showName;
    
    @Inject
    String name;
    
    @GET
    public String getMessage() {
        return this.echo + (showName ? " ".concat(name) : "");
    }
    
}
