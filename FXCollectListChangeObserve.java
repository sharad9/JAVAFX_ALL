import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class FXCollectListChangeObserve {
    public static void main(String args[]){
    List <String> list = new ArrayList <String> ();
    ObservableList<String> observableList = FXCollections.observableList(list);
    observableList.addListener(new ListChangeListener(){
        @Override
        public void onChanged(ListChangeListener.Change change){
            System.out.println("change!");
            
        }
    });
    observableList.add("item one");
    observableList.add("item extra");
    list.add("item two");
    System.out.println("Size:"+observableList.size());
    }

}
