package copunhackers.client.clientLogic;

import com.google.android.gms.maps.model.LatLng;

public class Message {

    public String username;
    public String content;
    public long creationTime = System.currentTimeMillis() /1000L;
    private long expiryTime;
    public double latitude;
    public double longitude;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
