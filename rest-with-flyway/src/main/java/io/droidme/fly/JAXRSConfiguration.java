/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly;

import io.droidme.fly.config.boundary.Property;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.flywaydb.core.Flyway;

/*
 * @author droidme
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

    @Inject
    @Property("dbClean")
    String dbClean;

    @Resource(lookup = "java:/jboss/datasources/sample")
    private DataSource ds;

    @PostConstruct
    public void init() {
        Flyway fly = new Flyway();
        fly.setDataSource(ds);
        if ("true".equals(dbClean)) {
            fly.clean();
        }
        fly.migrate();
    }

}
