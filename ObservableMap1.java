import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

public class ObservableMap1{
    public static void main(String args[]){
        Map <String , String> map = new HashMap<String , String>();
        ObservableMap<String, String > observableMap = FXCollections.observableMap(map);
        observableMap.addListener(new MapChangeListener() {
     @Override
     public void onChanged(MapChangeListener.Change change) {
        System.out.println("change! ");
      }
    });
        observableMap.put("key1","value 1");
        map.put("key 2","value 2");
    }
}