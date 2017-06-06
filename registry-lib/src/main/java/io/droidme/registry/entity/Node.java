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
public class Node {

    @JsonProperty("ID")
    public String id;
    
    @JsonProperty("Node")
    public String name;
    
    @JsonProperty("Address")
    public String address;
    
    @JsonProperty("Datacenter")
    public String datacenter;

}
