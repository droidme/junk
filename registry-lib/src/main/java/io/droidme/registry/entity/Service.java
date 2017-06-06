/*
 */
package io.droidme.registry.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author droidme
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {

    @JsonProperty("ID")
    public String id;
    
    @JsonProperty("Service")
    public String name;
    
    @JsonProperty("Tags")
    public List<String> tags;
    
    @JsonProperty("Address")
    public String address;
    
    @JsonProperty("Port")
    public String port;

}
