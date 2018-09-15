package motorq.ResponseClasses.GeotabResponse;

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
"latitude",
"longitude",
"speed",
"dateTime",
"device",
"id"
})
public class Datum implements Serializable
{

@JsonProperty("latitude")
private double latitude;
@JsonProperty("longitude")
private double longitude;
@JsonProperty("speed")
private int speed;
@JsonProperty("dateTime")
private String dateTime;
@JsonProperty("device")
private Device device;
@JsonProperty("id")
private String id;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 5675653074834040641L;

/**
* No args constructor for use in serialization
* 
*/
public Datum() {
}

/**
* 
* @param id
* @param dateTime
* @param speed
* @param device
* @param longitude
* @param latitude
*/
public Datum(double latitude, double longitude, int speed, String dateTime, Device device, String id) {
super();
this.latitude = latitude;
this.longitude = longitude;
this.speed = speed;
this.dateTime = dateTime;
this.device = device;
this.id = id;
}

@JsonProperty("latitude")
public double getLatitude() {
return latitude;
}

@JsonProperty("latitude")
public void setLatitude(double latitude) {
this.latitude = latitude;
}

public Datum withLatitude(double latitude) {
this.latitude = latitude;
return this;
}

@JsonProperty("longitude")
public double getLongitude() {
return longitude;
}

@JsonProperty("longitude")
public void setLongitude(double longitude) {
this.longitude = longitude;
}

public Datum withLongitude(double longitude) {
this.longitude = longitude;
return this;
}

@JsonProperty("speed")
public int getSpeed() {
return speed;
}

@JsonProperty("speed")
public void setSpeed(int speed) {
this.speed = speed;
}

public Datum withSpeed(int speed) {
this.speed = speed;
return this;
}

@JsonProperty("dateTime")
public String getDateTime() {
return dateTime;
}

@JsonProperty("dateTime")
public void setDateTime(String dateTime) {
this.dateTime = dateTime;
}

public Datum withDateTime(String dateTime) {
this.dateTime = dateTime;
return this;
}

@JsonProperty("device")
public Device getDevice() {
return device;
}

@JsonProperty("device")
public void setDevice(Device device) {
this.device = device;
}

public Datum withDevice(Device device) {
this.device = device;
return this;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

public Datum withId(String id) {
this.id = id;
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

public Datum withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}