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
        "items",
        "continuationToken"
})
public class HealthCore implements Serializable
{

    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("continuationToken")
    private String continuationToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5949849042546275129L;

    /**
     * No args constructor for use in serialization
     *
     */
    public HealthCore() {
    }

    /**
     *
     * @param continuationToken
     * @param items
     */
    public HealthCore(List<Item> items, String continuationToken) {
        super();
        this.items = items;
        this.continuationToken = continuationToken;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public HealthCore withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @JsonProperty("continuationToken")
    public String getContinuationToken() {
        return continuationToken;
    }

    @JsonProperty("continuationToken")
    public void setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    public HealthCore withContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
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

    public HealthCore withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
