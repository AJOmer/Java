import java.util.HashMap;
import java.util.Set;
public class MapOfHashmatique{
    public static void trackList(){
        HashMap<String, String> addTrack = new HashMap<String, String>();
        addTrack.put("Wake me up when September Ends", "Cause the clouds get gray as darkness expands");
        addTrack.put("Baby im just trying to put my hair cown", "Coast along the one and burn one");
        addTrack.put("Im like a bird i wanna fly away", "I dont know where my home is");
        addTrack.put("Do you remember", "Twentyfirst night of september");

        System.out.println("get song title by: "+ addTrack.get("Wake me up when September Ends"));

        Set<String> keys = addTrack.keySet();
        for(String key : keys){
            System.out.println(key);
            System.out.println(addTrack.get(key));

        }
    }
}