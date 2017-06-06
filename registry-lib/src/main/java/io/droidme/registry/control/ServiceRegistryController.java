/*
 */
package io.droidme.registry.control;

import io.droidme.registry.entity.HealthService;
import io.droidme.registry.entity.ServiceRegistration;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;

/**
 *
 * @author droidme
 */
public class ServiceRegistryController {
    
    public static final String URI = "http://localhost:8500";
    
    private final Client client = ClientBuilder.newClient();
    private final WebTarget target = client.target(URI);
    
    public List<HealthService> getHealthServices(String service) {
        
        try {
            Response response = target.path("/v1/health/service/{service}")
                    .resolveTemplate("service", service)
                    .queryParam("passing", true)
                    .request(APPLICATION_JSON)
                    .get();
            if (response.getStatusInfo().equals(OK)) {
                List<HealthService> services = response.readEntity(new GenericType<ArrayList<HealthService>>() {
                });
                return services;
            }
            
        } catch (Exception e) {
            // todo: some log output
        }
        
        return null;
        
    }
    
    public boolean registerService(ServiceRegistration registration) {
        
        try {
            Response response = target.path("/v1/agent/service/register")
                    .request(APPLICATION_JSON)
                    .put(Entity.json(registration));
            
            if (response.getStatusInfo().equals(OK)) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    public boolean deregisterService(String serviceId) {
        
        try {
            Response response = target.path("/v1/agent/service/deregister/{serviceId}")
                    .resolveTemplate("serviceId", serviceId)
                    .request(APPLICATION_JSON)
                    .put(Entity.text(""));
            
            if (response.getStatusInfo().equals(OK)) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
    
}
