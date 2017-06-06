/*
 */
package io.droidme.registry.control;

import io.droidme.registry.entity.HealthService;
import io.droidme.registry.entity.ServiceRegistration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author droidme
 */
public class ServiceRegistryControllerIT {
    
    ServiceRegistryController cut;
    
    @Before
    public void setUp() {
        cut = new ServiceRegistryController();
    }
    
    /**
     * Test of getHealthServices method, of class ServiceRegistryController.
     */
    @Test
    public void testGetHealthServices() {
        System.out.println("getHealthServices");
        String service = "myservice";
        List<HealthService> services = cut.getHealthServices(service);
        assertNotNull(services);
    }
    
    @Test
    public void testRegisterService() {
        ServiceRegistration registration = new ServiceRegistration(
                "it-0815", "test-service-by-integrationtest", "localhost", 8080);
        assertTrue(cut.registerService(registration));
    }
    
    @Test
    public void testDeRegisterService() {
        assertTrue(cut.deregisterService("it-0815"));
    }
}
