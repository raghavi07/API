package motorq.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.*;
import org.json.simple.JSONObject;

import com.jayway.restassured.response.Header;

public class MotorqConstants {

	public String accessToken = null;
	public String deviceID;
	public String limit = "500";

	// auth Endpoint
	public String authEndpoint = "https://motorq.auth0.com/oauth/token";

	/**
	 * This method set the accessToken to be used on upcoming requests
	 * @param authToken
	 */
	public void setAccessToken(String authToken) {
		accessToken = "Bearer " + authToken;
	}

	/**
	 * @return Header Object
	 */
	public Header getContentTypeHeader() {
		return new Header("Content-Type", "application/json");
	}

	/**
	 * @return Authentication Body
	 */
	public String getAuthBody() {
		JSONObject authParam = new JSONObject();
		authParam.put("client_id", "LMVCsA79au1drRP6WhvzYSFF9DpEJDEo");
		authParam.put("client_secret", "nENJL5u6REdXzghCEkVZEcXk_V1_b8soe25zf1VDJ4PrjzScYv3dilT4k9C_8hm4");
		authParam.put("audience", "https://corefleetqa.azurewebsites.net");
		authParam.put("grant_type", "client_credentials");
		return authParam.toJSONString();
	}

	// Status-Core Endpoint => /statuses/feed/status-core
	public String getStatusCoreEndpoint() {
		String statusCoreEndpoint = "https://motorqapi2test.azurewebsites.net/v2/statuses/feed?deviceId=DEVICE&startTimestamp="
				+ "TIME" + "&count=" + limit + "&feedTypes=status-core";
		return statusCoreEndpoint;
	}

	/**
	 * @return Header Object
	 */
	public Header getAuthHeader() {
		return new Header("Authorization", accessToken);
	}
}
