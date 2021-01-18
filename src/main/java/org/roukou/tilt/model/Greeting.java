package org.roukou.tilt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( { "request_id", "message" } )
public class Greeting
{
    @JsonProperty("request_id")
    private Long requestId;

    @JsonProperty("message")
    private String message;
}
