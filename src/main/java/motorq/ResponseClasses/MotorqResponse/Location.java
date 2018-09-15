package motorq.ResponseClasses.MotorqResponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"lat",
"lon"
})
public class Location implements Serializable
{

@JsonProperty("lat")
private double lat;
@JsonProperty("lon")
private double lon;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -7393671015373760715L;

/**
* No args constructor for use in serialization
* 
*/
public Location() {
}

/**
* 
* @param lon
* @param lat
*/
public Location(double lat, double lon) {
super();
this.lat = lat;
this.lon = lon;
}

@JsonProperty("lat")
public double getLat() {
return lat;
}

@JsonProperty("lat")
public void setLat(double lat) {
this.lat = lat;
}

public Location withLat(double lat) {
this.lat = lat;
return this;
}

@JsonProperty("lon")
public double getLon() {
return lon;
}

@JsonProperty("lon")
public void setLon(double lon) {
this.lon = lon;
}

public Location withLon(double lon) {
this.lon = lon;
return this;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Location withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}