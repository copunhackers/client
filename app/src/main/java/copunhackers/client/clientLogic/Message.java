package copunhackers.client.clientLogic;

import com.google.android.gms.maps.model.LatLng;

public class Message {

    private String username;
    private String content;
    private long creationTime = System.currentTimeMillis() /1000L;
    private long expiryTime;
    private LatLng location;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = content;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long duration) {
        this.expiryTime = getCreationTime() + duration*60;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

}
