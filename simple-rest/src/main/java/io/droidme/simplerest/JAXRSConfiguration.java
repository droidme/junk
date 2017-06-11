/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.simplerest;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

/**
 * Configures a JAX-RS endpoint.
 *
 * @author droidme
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

    @Context
    ServletContext context;

    @Inject
    Logger log;

    @PostConstruct
    void startUp() {
        log.info("startup ....");
        log.info("context path: " + context.getContextPath());
        log.info("context server name: " + context.getVirtualServerName());

    }

    @PreDestroy
    void shutDown() {
        log.info("shutdown ...");

    }

}
