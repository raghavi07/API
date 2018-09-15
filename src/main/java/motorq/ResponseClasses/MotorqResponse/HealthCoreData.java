package motorq.ResponseClasses.MotorqResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        "vehicleBatteryVoltage",
        "engineCoolantTempC",
        "milStatus",
        "dtcActive"
})
public class HealthCoreData implements Serializable
{

    @JsonProperty("vehicleId")
    private String vehicleId;
    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("vehicleBatteryVoltage")
    private double vehicleBatteryVoltage;
    @JsonProperty("engineCoolantTempC")
    private Object engineCoolantTempC;
    @JsonProperty("milStatus")
    private Object milStatus;
    @JsonProperty("dtcActive")
    private List<Object> dtcActive = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6161455293686475340L;

    /**
     * No args constructor for use in serialization
     *
     */
    public HealthCoreData() {
    }

    /**
     *
     * @param timestamp
     * @param vehicleId
     * @param vehicleBatteryVoltage
     * @param engineCoolantTempC
     * @param dtcActive
     * @param milStatus
     * @param deviceId
     */
    public HealthCoreData(String vehicleId, String deviceId, String timestamp, double vehicleBatteryVoltage, Object engineCoolantTempC, Object milStatus, List<Object> dtcActive) {
        super();
        this.vehicleId = vehicleId;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.vehicleBatteryVoltage = vehicleBatteryVoltage;
        this.engineCoolantTempC = engineCoolantTempC;
        this.milStatus = milStatus;
        this.dtcActive = dtcActive;
    }

    @JsonProperty("vehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    @JsonProperty("vehicleId")
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public HealthCoreData withVehicleId(String vehicleId) {
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

    public HealthCoreData withDeviceId(String deviceId) {
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

    public HealthCoreData withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("vehicleBatteryVoltage")
    public double getVehicleBatteryVoltage() {
        return vehicleBatteryVoltage;
    }

    @JsonProperty("vehicleBatteryVoltage")
    public void setVehicleBatteryVoltage(double vehicleBatteryVoltage) {
        this.vehicleBatteryVoltage = vehicleBatteryVoltage;
    }

    public HealthCoreData withVehicleBatteryVoltage(double vehicleBatteryVoltage) {
        this.vehicleBatteryVoltage = vehicleBatteryVoltage;
        return this;
    }

    @JsonProperty("engineCoolantTempC")
    public Object getEngineCoolantTempC() {
        return engineCoolantTempC;
    }

    @JsonProperty("engineCoolantTempC")
    public void setEngineCoolantTempC(Object engineCoolantTempC) {
        this.engineCoolantTempC = engineCoolantTempC;
    }

    public HealthCoreData withEngineCoolantTempC(Object engineCoolantTempC) {
        this.engineCoolantTempC = engineCoolantTempC;
        return this;
    }

    @JsonProperty("milStatus")
    public Object getMilStatus() {
        return milStatus;
    }

    @JsonProperty("milStatus")
    public void setMilStatus(Object milStatus) {
        this.milStatus = milStatus;
    }

    public HealthCoreData withMilStatus(Object milStatus) {
        this.milStatus = milStatus;
        return this;
    }

    @JsonProperty("dtcActive")
    public List<Object> getDtcActive() {
        return dtcActive;
    }

    @JsonProperty("dtcActive")
    public void setDtcActive(List<Object> dtcActive) {
        this.dtcActive = dtcActive;
    }

    public HealthCoreData withDtcActive(List<Object> dtcActive) {
        this.dtcActive = dtcActive;
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

    public HealthCoreData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}