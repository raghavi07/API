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
"result",
"jsonrpc"
})
public class LogRecord implements Serializable
{

@JsonProperty("result")
private Result result;
@JsonProperty("jsonrpc")
private String jsonrpc;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 7440397644202049049L;

/**
* No args constructor for use in serialization
* 
*/
public LogRecord() {
}

/**
* 
* @param result
* @param jsonrpc
*/
public LogRecord(Result result, String jsonrpc) {
super();
this.result = result;
this.jsonrpc = jsonrpc;
}

@JsonProperty("result")
public Result getResult() {
return result;
}

@JsonProperty("result")
public void setResult(Result result) {
this.result = result;
}

public LogRecord withResult(Result result) {
this.result = result;
return this;
}

@JsonProperty("jsonrpc")
public String getJsonrpc() {
return jsonrpc;
}

@JsonProperty("jsonrpc")
public void setJsonrpc(String jsonrpc) {
this.jsonrpc = jsonrpc;
}

public LogRecord withJsonrpc(String jsonrpc) {
this.jsonrpc = jsonrpc;
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

public LogRecord withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}