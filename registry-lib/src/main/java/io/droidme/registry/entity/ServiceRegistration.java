/*
 */
package io.droidme.registry.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 *
 * @author droidme
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRegistration {

    @JsonProperty("ID")
    public String id;

    @JsonProperty("Name")
    public String name;

    @JsonProperty("Tags")
    public String[] tags;

    @JsonProperty("Address")
    public String address;

    @JsonProperty("Port")
    public int port;

    @JsonProperty("Check")
    public Check check;

    public ServiceRegistration() {
    }

    public ServiceRegistration(String serviceName, String address, int port) {
        this.id = UUID.randomUUID().toString();
        this.name = serviceName;
        this.address = address;
        this.port = port;
    }

    public ServiceRegistration(String serviceId, String serviceName, String address, int port) {
        this.id = serviceId;
        this.name = serviceName;
        this.address = address;
        this.port = port;
    }

    public ServiceRegistration(String serviceName, String address, int port, Check check) {
        this(serviceName, address, port);
        this.check = check;
    }

    public ServiceRegistration(String id, String name, String address, int port, Check check, String... tags) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.port = port;
        this.tags = tags;
        this.check = check;
    }

}
