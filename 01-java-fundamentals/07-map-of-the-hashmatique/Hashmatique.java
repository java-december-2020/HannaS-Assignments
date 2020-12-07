import java.util.HashMap;
import java.util.Set; 
public class Hashmatique{

    public static void main(String[] args){
HashMap<String, String> trackList = new HashMap<String, String>();
trackList.put("Gravity" , "Gravity is working against me...");
trackList.put("New Light" , "I'm the boy in your other phone...");
trackList.put("Edge of Desire" , "Young and full of running...");
trackList.put("Love on the Weekend" , "It's a Friday, we finally made it...");

String trackLyrics = trackList.get("Love on the Weekend");
System.out.println(trackLyrics);

Set<String> keys = trackList.keySet();
for (String key : keys){
    System.out.println(key);
    System.out.println(trackList.get(key));
        }

    }

}