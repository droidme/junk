/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly.config.boundary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author droidme
 */
public class PropertyProducer {
    
    private Properties properties;
    
    @Produces
    public String produceString(final InjectionPoint ip) {
        return this.properties.getProperty(getKey(ip));
    }
    
    @Produces
    public int produceInt(final InjectionPoint ip) {
        return Integer.parseInt(this.properties.getProperty(getKey(ip)));
    }
    
    @Produces
    public boolean produceBoolean(final InjectionPoint ip) {
        return Boolean.parseBoolean(this.properties.getProperty(getKey(ip)));
    }
    
    private String getKey(final InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        String key = className + "." + ip.getMember().getName();
        if (ip.getAnnotated().isAnnotationPresent(Property.class)
                && !ip.getAnnotated().getAnnotation(Property.class).value().isEmpty()) {
            key = ip.getAnnotated().getAnnotation(Property.class).value();
        }
        return key;
    }
    
    @PostConstruct
    public void init() {
        this.properties = new Properties();
        final InputStream is = getClass().getClassLoader()
                .getResourceAsStream("application.properties");
        if (is == null) {
            throw new RuntimeException("no property file (application.properties) found");
        }
        try {
            this.properties.load(is);
        } catch (IOException ex) {
            throw new RuntimeException("Configuration could not be loaded.");
        }
    }
        
}
