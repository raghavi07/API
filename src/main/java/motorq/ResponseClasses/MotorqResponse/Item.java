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
@JsonPropertyOrder({ "feedType", "data" })
public class Item implements Serializable {

	@JsonProperty("feedType")
	private String feedType;
	@JsonProperty("data")
	private Data data;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -3883228079627653935L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Item() {
	}

	/**
	 * 
	 * @param feedType
	 * @param data
	 */
	public Item(String feedType, Data data) {
		super();
		this.feedType = feedType;
		this.data = data;
	}

	@JsonProperty("feedType")
	public String getFeedType() {
		return feedType;
	}

	@JsonProperty("feedType")
	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public Item withFeedType(String feedType) {
		this.feedType = feedType;
		return this;
	}

	@JsonProperty("data")
	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
	}

	public Item withData(Data data) {
		this.data = data;
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

	public Item withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}