package copunhackers.client.clientLogic;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;

/**
 * Created by vrettos on 22.04.2017.
 */

public class Parser {


    public void jsonToMessage(String json){

        ObjectMapper mapper = new ObjectMapper();


        try{
            Message message = mapper.readValue(json, Message.class);

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(student);

            System.out.println(jsonString);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void messageToJson(Message message){
        try{

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            json = mapper.writeValueAsString(message);

            System.out.println(jsonString);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

}
