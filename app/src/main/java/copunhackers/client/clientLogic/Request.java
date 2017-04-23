package copunhackers.client.clientLogic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
// https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/

/**
 * Created by Andreas on 22-04-2017.
 */
public class Request {

   /* public static void main(String[] args)throws IOException{
        serverRequest sr = new serverRequest();
        sr.dropMessage("{\"namekey\":\"Testing dropMessage\"}");
        sr.gatherMessage("{\"namekey\":\"Testing gatherMessage\"}");
    }*/


    public String gatherMessage(String jsonStringObject)throws IOException{
        return work(jsonStringObject, "message");
    }

    public String dropMessage(String jsonStringObject) throws IOException {
        return work(jsonStringObject, "drop");
    }

    public String work(String jsonStringObject, String style)throws IOException{
        String url = "http://teal.basilehenry.com:5000/"+style;

        URL obj = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(jsonStringObject);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + jsonStringObject);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return response.toString();
    }
}
