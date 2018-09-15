package motorq.Constants;

public class GeotabConstants {
	
	MotorqConstants motorqConstants = new MotorqConstants();

	// Log Record Request Params
	public String logRecordEndpoint = "https://my184.geotab.com/apiv1";

	/**
	 * This method is used to get the LogRecord Request Body in String format
	 * @return body in String format
	 */
	public String getLogRecordBody() {
		String body = "{\"method\": \"GetFeed\",\"params\": {\"typeName\": \"LogRecord\", \"resultsLimit\": "+motorqConstants.limit+",\"search\": {\"fromDate\": \""+"TIME"+"\",\"DeviceSearch\" : {id: \"b1\" },},\"credentials\": { \"database\": \"motorq\",\"sessionId\": \"4475361183873173625\",\"userName\": \"vivek@motorq.co\"}}}";
		return body;
	}

	// Status Data Request Params
	public String statusDataEndpoint = "https://my184.geotab.com/apiv1";

	/**
	 * This method is used to get the StatusData Request Body in String format
	 * @return body in String format
	 */
	public String getStatusDataBody() {
		String body = "{\"method\": \"GetFeed\",\"params\": {\"typeName\": \"StatusData\", \"resultsLimit\": "+motorqConstants.limit+",\"search\": {\"fromDate\": \""+"TIME"+"\",\"DiagnosticSearch\" : {id: \"DiagnosticOdometerId\" },\"DeviceSearch\" : {id: \"b1\" },},\"credentials\": { \"database\": \"motorq\",\"sessionId\": \"4475361183873173625\",\"userName\": \"vivek@motorq.co\"}}}";
		return body;
	}
	
}
