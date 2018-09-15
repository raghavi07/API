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
@JsonPropertyOrder({ "vehicleId", "deviceId", "timestamp", "location", "speedCanMph", "speedGpsMph", "ignitionStatus" })
public class Data implements Serializable {

	@JsonProperty("vehicleId")
	private String vehicleId;
	@JsonProperty("deviceId")
	private String deviceId;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("speedCanMph")
	private Object speedCanMph;
	@JsonProperty("speedGpsMph")
	private int speedGpsMph;
	@JsonProperty("ignitionStatus")
	private String ignitionStatus;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -3076878861089366640L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Data() {
	}

	/**
	 * 
	 * @param timestamp
	 * @param speedCanMph
	 * @param vehicleId
	 * @param location
	 * @param speedGpsMph
	 * @param deviceId
	 * @param ignitionStatus
	 */
	public Data(String vehicleId, String deviceId, String timestamp, Location location, Object speedCanMph,
			int speedGpsMph, String ignitionStatus) {
		super();
		this.vehicleId = vehicleId;
		this.deviceId = deviceId;
		this.timestamp = timestamp;
		this.location = location;
		this.speedCanMph = speedCanMph;
		this.speedGpsMph = speedGpsMph;
		this.ignitionStatus = ignitionStatus;
	}

	@JsonProperty("vehicleId")
	public String getVehicleId() {
		return vehicleId;
	}

	@JsonProperty("vehicleId")
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Data withVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
		return this;
	}

	@JsonProperty("deviceId")
	public String getDeviceId() {
		return deviceId;
	}

	@JsonProperty("deviceId")
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Data withDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Data withTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	public Data withLocation(Location location) {
		this.location = location;
		return this;
	}

	@JsonProperty("speedCanMph")
	public Object getSpeedCanMph() {
		return speedCanMph;
	}

	@JsonProperty("speedCanMph")
	public void setSpeedCanMph(Object speedCanMph) {
		this.speedCanMph = speedCanMph;
	}

	public Data withSpeedCanMph(Object speedCanMph) {
		this.speedCanMph = speedCanMph;
		return this;
	}

	@JsonProperty("speedGpsMph")
	public int getSpeedGpsMph() {
		return speedGpsMph;
	}

	@JsonProperty("speedGpsMph")
	public void setSpeedGpsMph(int speedGpsMph) {
		this.speedGpsMph = speedGpsMph;
	}

	public Data withSpeedGpsMph(int speedGpsMph) {
		this.speedGpsMph = speedGpsMph;
		return this;
	}

	@JsonProperty("ignitionStatus")
	public String getIgnitionStatus() {
		return ignitionStatus;
	}

	@JsonProperty("ignitionStatus")
	public void setIgnitionStatus(String ignitionStatus) {
		this.ignitionStatus = ignitionStatus;
	}

	public Data withIgnitionStatus(String ignitionStatus) {
		this.ignitionStatus = ignitionStatus;
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

	public Data withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}