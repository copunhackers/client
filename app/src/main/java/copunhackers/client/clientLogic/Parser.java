package copunhackers.client.clientLogic;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Parser {


    public Message jsonToMessage(String json){

        ObjectMapper mapper = new ObjectMapper();
        try{
            Message message = mapper.readValue(json, Message.class);

            return message;
        }
        catch (JsonParseException e) { e.printStackTrace();return null;}
        catch (JsonMappingException e) { e.printStackTrace(); return null;}
        catch (IOException e) { e.printStackTrace(); return null;}
    }

    public String messageToJson(Message message){

        ObjectMapper mapper = new ObjectMapper();

        try{
            String json = mapper.writeValueAsString(message);

            return json;
        }
        catch (JsonParseException e) { e.printStackTrace(); return null;}
        catch (JsonMappingException e) { e.printStackTrace(); return null;}
        catch (IOException e) { e.printStackTrace(); return null;}
    }

}