/*
 */
package io.droidme.registry.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author droidme
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthService {
    
    @JsonProperty("Node")
    public Node node;
    
    @JsonProperty("Service")
    public Service service;

    @Override
    public String toString() {
        return "HealthService{" + "node=" + node + ", service=" + service + '}';
    }

}
