package copunhackers.client.clientLogic;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;


/**
 * Created by vrettos on 23.04.2017.
 */

public class Logic {

    private double currentLat;
    private double currentLong;
    private Parser parser;
    private Request request;

    public Logic() {
        currentLat = 0;
        currentLong = 0;
        parser = new Parser();
        request = new Request();
    }

    public void setCurrentLocation(double lat, double lng){
        currentLat = lat;
        currentLong = lng;
    }

    public String prepareMessage(String username, String content){
        Message message = new Message();
        String json;

        message.setUsername(username);
        message.setContent(content);
        //creationTime is set automatically
        message.setExpiryTime(60);
        message.setLatitude(currentLat);
        message.setLongitude(currentLong);
        System.out.println(message.toString());

        json = parser.messageToJson(message).toString();
        try {
            return request.dropMessage(json);
        }
        catch(IOException e){e.printStackTrace(); return null;}
    }

    public Message[] getMessages(double lat, double lng){
        String jsonArray = "";
        try {
            jsonArray = request.gatherMessage("{\"latitude\":" + lat + ",\"longitude\":" + lng + "}");
        }catch(IOException e){e.printStackTrace();}

        Message[] toDisplay = parser.messagesToDisplay(jsonArray);
        System.out.println(toDisplay.toString());
        return toDisplay;
    }


}
