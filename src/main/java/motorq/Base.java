package motorq;

import java.util.List;

import motorq.Constants.GeotabConstants;
import motorq.Constants.MotorqConstants;
import motorq.ResponseClasses.MotorqResponse.Auth;
import motorq.jsonParserUtil.jsonParserHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

public class Base {

	MotorqConstants motorqConstants = new MotorqConstants();
	GeotabConstants geotabCons = new GeotabConstants();
	jsonParserHelper helper = new jsonParserHelper();

	/**
	 * This method sets the bearerToken to all the upcoming request. make sure to call this first in tests
	 */
	public void setAuthToken() {
		Response response = (Response) given().header(motorqConstants.getContentTypeHeader())
				.body(motorqConstants.getAuthBody()).post(motorqConstants.authEndpoint);
		Auth responseObj = null;
		try {
			responseObj = new ObjectMapper().readValue(response.body().asString(), Auth.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String authToken = responseObj.getAccessToken();
		System.out.println("Access Token : " + authToken);
		motorqConstants.setAccessToken(authToken);
	}

	/**
	 * This method is used when HTTP Get method to be called
	 * @param endpoint - Request Endpoint
	 * @param header - Request Header value
	 * @return Response Body in String format
	 */
	public String getRequest(String endpoint, Header header) {
		Response response = (Response) given().header(header).get(endpoint);
		return response.body().asString();
	}

	/**
	 * This method is used when HTTP post method to be called
	 * @param endpoint - Request Endpoint
	 * @param header - Request Header Value
	 * @param body - Request Body
	 * @return Response Body in String format
	 */
	private String postRequest(String endpoint, Header header, String body) {
		Response response = (Response) given().header(header).body(body).post(endpoint);
		return response.body().asString();
	}

	/**
	 * This method is called when Motorq StatusCore Response is needed
	 * @param timestamp
	 * @return Response in String format
	 */
	public String getStatusCoreResponse(String timestamp, String devideID) {
        String endPoint = motorqConstants.getStatusCoreEndpoint().replace("TIME",timestamp);
		endPoint = endPoint.replace("DEVICE",devideID);
		String response = getRequest(endPoint, motorqConstants.getAuthHeader());
		return response;
	}

	/**
	 * This method is called when Geotab LogRecord Response is needed
	 * @param timestamp
	 * @return Response in String format
	 */
	public String geotab_logRecordResponse(String timestamp) {
        String endPoint = geotabCons.logRecordEndpoint;
        String body = geotabCons.getLogRecordBody().replace("TIME",timestamp);
		String response = postRequest(endPoint, motorqConstants.getContentTypeHeader(),
				body);
		return response;
	}

	/**
	 * This method is not validated, No data in Geotab
	 */
	public String geotab_statusDataResponse(String timestamp) {
		String endPoint = geotabCons.statusDataEndpoint;
		String body = geotabCons.getStatusDataBody().replace("TIME",timestamp);
		String response = postRequest(endPoint, motorqConstants.getContentTypeHeader(),
				body);
		return response;
	}
}
