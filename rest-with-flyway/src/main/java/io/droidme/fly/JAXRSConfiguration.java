/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.flywaydb.core.Flyway;

 /*
 * @author droidme
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
    
    @Resource(lookup = "java:/jboss/datasources/sample")
    private DataSource ds;
    
    @PostConstruct
    public void init() {
        Flyway fly = new Flyway();
        fly.setDataSource(ds);
        fly.clean();
        fly.migrate();
    }

}
