package motorq.jsonParserUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import motorq.ResponseClasses.MotorqResponse.Item;
import motorq.ResponseClasses.MotorqResponse.StatusCore;
import motorq.ResponseClasses.GeotabResponse.Datum;
import motorq.ResponseClasses.GeotabResponse.LogRecord;
import motorq.ResponseClasses.GeotabResponse.Result;

public class jsonParserHelper {

	/**
	 * This method gives Motorq timestamp list from the response
	 * @param response
	 * @return timeStamp list
	 */
	public List<String> getTimeStampList(String response) {
		List<String> timeStamp = new ArrayList<String>();
		try {
			StatusCore responseObj = new ObjectMapper().readValue(response, StatusCore.class);
			List<Item> values = responseObj.getItems();
			for (Item value : values) {
				timeStamp.add(value.getData().getTimestamp());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp;
	}

	/**
	 * This method gives Geotab timestamp list from the response
	 * @param response
	 * @return timeStamp list
	 */
	public List<String> geotab_getTimeStampList(String response) {
		List<String> timeStamp = new ArrayList<String>();
		try {
			LogRecord responseObj = new ObjectMapper().readValue(response, LogRecord.class);
			Result result = responseObj.getResult();
			List<Datum> values = result.getData();
			for (Datum value : values) {
				timeStamp.add(value.getDateTime());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp;
	}

	/**
	 * This method is used to get Motorq timestamp Vs Latitude and Longitude
	 * @param response
	 * @return Hashmap which has key = timestamp string and value = Latitude and Longitude list
	 */
	public Map<String,List> getTimeStamp_LatLon(String response) {
		Map<String,List> timeStamp_LatLon = new HashMap<String,List>();
		try {
			StatusCore responseObj = new ObjectMapper().readValue(response, StatusCore.class);
			List<Item> values = responseObj.getItems();
			for (Item value : values) {
				List<Double> latLonList = new ArrayList<Double>();
				latLonList.add(value.getData().getLocation().getLat());
				latLonList.add(value.getData().getLocation().getLon());
				timeStamp_LatLon.put(value.getData().getTimestamp(),latLonList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp_LatLon;
	}

	/**
	 * This method is used to get Geotab timestamp Vs Latitude and Longitude
	 * @param response
	 * @return Hashmap which has key = timestamp string and value = Latitude and Longitude list
	 */
	public Map<String,List> geotab_getTimeStamp_LatLon(String response) {
		Map<String,List> timeStamp_LatLon = new HashMap<String,List>();
		try {
			LogRecord responseObj = new ObjectMapper().readValue(response, LogRecord.class);
			Result result = responseObj.getResult();
			List<Datum> values = result.getData();
			for (Datum value : values) {
				List<Double> latLonList = new ArrayList<Double>();
				latLonList.add(value.getLatitude());
				latLonList.add(value.getLongitude());
				timeStamp_LatLon.put(value.getDateTime(),latLonList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp_LatLon;
	}

	/**
	 * This method is used to get the Motorq timestamp Vs IgnitionStatus
	 * @param response
	 * @return Hashmap which has key = timestamp string and value = IgnitionStatus string
	 */
	public Map<String,String> getTimeStamp_IgnitionStatus(String response) {
		Map<String,String> timeStamp_Ign = new HashMap<String,String>();
		try {
			StatusCore responseObj = new ObjectMapper().readValue(response, StatusCore.class);
			List<Item> values = responseObj.getItems();
			for (Item value : values) {
				timeStamp_Ign.put(value.getData().getTimestamp(),value.getData().getIgnitionStatus());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp_Ign;
	}

	/**
	 * This method is used to get the Geotab timestamp Vs IgnitionStatus
	 * @param response
	 * @return Hashmap which has key = timestamp string and value = IgnitionStatus string
	 */
	public Map<String,Integer> geotab_getTimeStamp_IgnitionStatus(String response) {
		Map<String,Integer> timeStamp_Ign = new HashMap<String,Integer>();
		try {
			LogRecord responseObj = new ObjectMapper().readValue(response, LogRecord.class);
			Result result = responseObj.getResult();
			List<Datum> values = result.getData();
			for (Datum value : values) {
				timeStamp_Ign.put(value.getDateTime(),value.getSpeed());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp_Ign;
	}

	/**
	 * This method is used to get the Motorq timestamp Vs Speed
	 * @param response
	 * @return Hashmap which has key = timestamp string and value = SpeedGps string
	 */
	public Map<String,String> getTimeStamp_SpeedGps(String response) {
		Map<String,String> timeStamp_Ign = new HashMap<String,String>();
		try {
			StatusCore responseObj = new ObjectMapper().readValue(response, StatusCore.class);
			List<Item> values = responseObj.getItems();
			for (Item value : values) {
				timeStamp_Ign.put(value.getData().getTimestamp(),value.getData().getIgnitionStatus());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp_Ign;
	}
}