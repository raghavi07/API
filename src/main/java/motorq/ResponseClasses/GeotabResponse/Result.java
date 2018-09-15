package motorq.ResponseClasses.GeotabResponse;

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
@JsonPropertyOrder({ "data", "toVersion" })
public class Result implements Serializable {

	@JsonProperty("data")
	private List<Datum> data = new ArrayList<Datum>();
	@JsonProperty("toVersion")
	private String toVersion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -6392973503458995093L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Result() {
	}

	/**
	 * 
	 * @param data
	 * @param toVersion
	 */
	public Result(List<Datum> data, String toVersion) {
		super();
		this.data = data;
		this.toVersion = toVersion;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}

	public Result withData(List<Datum> data) {
		this.data = data;
		return this;
	}

	@JsonProperty("toVersion")
	public String getToVersion() {
		return toVersion;
	}

	@JsonProperty("toVersion")
	public void setToVersion(String toVersion) {
		this.toVersion = toVersion;
	}

	public Result withToVersion(String toVersion) {
		this.toVersion = toVersion;
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

	public Result withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}
