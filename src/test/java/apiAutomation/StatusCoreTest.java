package apiAutomation;

import motorq.Base;
import motorq.Constants.MotorqConstants;
import motorq.jsonParserUtil.jsonParserHelper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatusCoreTest {

    Base base = new Base();
    MotorqConstants motorqConst = new MotorqConstants();
    jsonParserHelper jsonParser = new jsonParserHelper();

    String motorqResponse;
    String geotabResponse;
    List<String> motorqTime;
    List<String> geoTime;
    Map<String,List> motorq_timeLatLon;
    Map<String,List> geotab_timeLatLon;
    String timestamp;
    int MAX_ITERATION;
    String deviceID;

    String testDataPath = System.getProperty("user.dir")+"/TestData.properties";
    String currentTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    String missingTimeStampPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Output\\Missing_Timestamp_"+currentTime+".txt";
    String mismatchLatitudePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Output\\Mismatch_Latitude_"+currentTime+".txt";
    String mismatchLongitudePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Output\\Mismatch_Longitude_"+currentTime+".txt";
    String duplicateTimestampPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Output\\Duplicate_Longitude_"+currentTime+".txt";

    ;

    @BeforeTest
    public void loadTestData() {
        System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(testDataPath);
            prop.load(inputFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        timestamp = prop.getProperty("timeStamp");
        MAX_ITERATION = Integer.parseInt(prop.getProperty("MAX_ITERATION"));
        deviceID = prop.getProperty("deviceID");
    }

    /**
     * This test drives the Missig Timestamp and Mismatch Latitude and Longitude test
     */
    @Test
    public void runTests() {
        // This method sets the Bearer Token to all the upcoming request
        base.setAuthToken();
        // checks MAX_ITERATION*500 times of timestamp (single response has max of 500 list)
        int iteration=MAX_ITERATION;

        while((iteration--)>0) {
            motorqResponse = base.getStatusCoreResponse(timestamp,deviceID);
            geotabResponse = base.geotab_logRecordResponse(timestamp);
            motorqTime = jsonParser.getTimeStampList(motorqResponse);
            geoTime = jsonParser.geotab_getTimeStampList(geotabResponse);
            motorq_timeLatLon = jsonParser.getTimeStamp_LatLon(motorqResponse);
            geotab_timeLatLon = jsonParser.geotab_getTimeStamp_LatLon(geotabResponse);
            // Validate Missing Timestamp
            validateMissingTimestamp();
            // Validate Mismatch Latitude
            validateLatitude();
            // Validate Mismatch Longitude
            validateLongitude();
            //Validate Duplicate Timestamp
            validateDuplicateTimestamp();
            String mintime = Collections.min(motorqTime);
            String maxtimestamp = Collections.max(motorqTime);
            if (timestamp.equals(maxtimestamp)){
                break;
            }
            // Using this as a startTimestamp in next iteration
            timestamp=maxtimestamp;
            System.out.println("Checking from - "+mintime+" to - "+timestamp);
        }
    }

    public void validateMissingTimestamp() {
        for (String timestamp : geoTime) {
            if (motorqTime.contains(timestamp)) {
                writeInFile(missingTimeStampPath,"Geotab Timestamp missing in Motorq -> "+timestamp);
            }
        }
    }

    public void validateLatitude() {
        for (String timeStamp : geotab_timeLatLon.keySet()) {
            if (motorq_timeLatLon.containsKey(timeStamp)) {
                String lat = motorq_timeLatLon.get(timeStamp).get(0).toString();
                String geoLat = geotab_timeLatLon.get(timeStamp).get(0).toString();
                if (!lat.equals(geoLat)) {
                    writeInFile(mismatchLatitudePath,"Mismatch Latitude Timestamp -> " + timeStamp + " - Motorq lat-> " + lat + " - Geotab lat -> " + geoLat);
                }
            }
        }
    }

    public void validateLongitude() {
        for (String timeStamp : geotab_timeLatLon.keySet()) {
            if (motorq_timeLatLon.containsKey(timeStamp)) {
                String lon = motorq_timeLatLon.get(timeStamp).get(1).toString();
                String geoLon = geotab_timeLatLon.get(timeStamp).get(1).toString();
                if (!lon.equals(geoLon)) {
                    writeInFile(mismatchLongitudePath,"Latitude Not Matching Timestamp -> " + timeStamp + " - Motorq lat-> " + lon + " - Geotab lat -> " + geoLon);
                }
            }
        }
    }

    public void validateDuplicateTimestamp() {
        int size = motorqTime.size();
        for (int i=0;i<size-1;i++) {
            if(motorqTime.get(i).equals(motorqTime.get(i+1))){
                writeInFile(duplicateTimestampPath,"Duplicate Timestamp -> "+motorqTime.get(i));
            }
        }
    }

    public void writeInFile(String path, String text) {
        try (FileWriter fw = new FileWriter(path, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw))
        {
            out.println(text);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

