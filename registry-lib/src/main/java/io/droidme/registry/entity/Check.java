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
public class Check {

    @JsonProperty("HTTP")
    public String http;

    @JsonProperty("Interval")
    public Integer interval;

    public Check() {
    }

    public Check(String http, Integer interval) {
        this.http = http;
        this.interval = interval;
    }

}
