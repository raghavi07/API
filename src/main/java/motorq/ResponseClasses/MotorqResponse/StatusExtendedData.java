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
        "vehicleId",
        "deviceId",
        "timestamp",
        "odometerCanMi",
        "odometerGpsMi",
        "fuelLevelPct"
})
public class StatusExtendedData implements Serializable
{

    @JsonProperty("vehicleId")
    private String vehicleId;
    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("odometerCanMi")
    private int odometerCanMi;
    @JsonProperty("odometerGpsMi")
    private Object odometerGpsMi;
    @JsonProperty("fuelLevelPct")
    private double fuelLevelPct;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4836010482401102845L;

    /**
     * No args constructor for use in serialization
     *
     */
    public StatusExtendedData() {
    }

    /**
     *
     * @param timestamp
     * @param odometerGpsMi
     * @param vehicleId
     * @param fuelLevelPct
     * @param deviceId
     * @param odometerCanMi
     */
    public StatusExtendedData(String vehicleId, String deviceId, String timestamp, int odometerCanMi, Object odometerGpsMi, double fuelLevelPct) {
        super();
        this.vehicleId = vehicleId;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.odometerCanMi = odometerCanMi;
        this.odometerGpsMi = odometerGpsMi;
        this.fuelLevelPct = fuelLevelPct;
    }

    @JsonProperty("vehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    @JsonProperty("vehicleId")
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public StatusExtendedData withVehicleId(String vehicleId) {
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

    public StatusExtendedData withDeviceId(String deviceId) {
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

    public StatusExtendedData withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("odometerCanMi")
    public int getOdometerCanMi() {
        return odometerCanMi;
    }

    @JsonProperty("odometerCanMi")
    public void setOdometerCanMi(int odometerCanMi) {
        this.odometerCanMi = odometerCanMi;
    }

    public StatusExtendedData withOdometerCanMi(int odometerCanMi) {
        this.odometerCanMi = odometerCanMi;
        return this;
    }

    @JsonProperty("odometerGpsMi")
    public Object getOdometerGpsMi() {
        return odometerGpsMi;
    }

    @JsonProperty("odometerGpsMi")
    public void setOdometerGpsMi(Object odometerGpsMi) {
        this.odometerGpsMi = odometerGpsMi;
    }

    public StatusExtendedData withOdometerGpsMi(Object odometerGpsMi) {
        this.odometerGpsMi = odometerGpsMi;
        return this;
    }

    @JsonProperty("fuelLevelPct")
    public double getFuelLevelPct() {
        return fuelLevelPct;
    }

    @JsonProperty("fuelLevelPct")
    public void setFuelLevelPct(double fuelLevelPct) {
        this.fuelLevelPct = fuelLevelPct;
    }

    public StatusExtendedData withFuelLevelPct(double fuelLevelPct) {
        this.fuelLevelPct = fuelLevelPct;
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

    public StatusExtendedData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}