package copunhackers.client.clientLogic;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;


/**
 * Created by vrettos on 23.04.2017.
 */

public class Logic {
    public LatLng currentLocation;
    public Parser parser;
    public serverRequest request;

    public void setCurrentLocation(LatLng loc){
        currentLocation = loc;

    }

    public void prepareMessage(String username, String content){
        Message message = new Message();
        String json;

        message.setUsername(username);
        message.setContent(content);
        //creationTime is set already
        message.setExpiryTime(60);
        message.setLocation(currentLocation);
        System.out.println(message.toString());

        json = parser.messageToJson(message).toString();
        try {
            request.dropMessage(json);
        }
        catch(IOException e){e.printStackTrace();}

    }


}
