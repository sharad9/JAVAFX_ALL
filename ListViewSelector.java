import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewSelector extends Application{

    public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage){
      ObservableList<String> names = FXCollections.observableArrayList();
      ObservableList<String> data = FXCollections.observableArrayList();
      
      ListView<String> listView = new ListView<String>(data);
      listView.setPrefSize(200, 300);
      listView.setEditable(true);
      
      names.addAll(
             "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown"
        );
      
      
      
      for(int i = 0; i < 18; i++){
        data.add("Double Click to Select Value ---"+i);
        }
      
      listView.setItems(data);
      listView.setCellFactory(ComboBoxListCell.forListView(names));
      
      StackPane root = new StackPane();
      root.getChildren().add(listView);
      stage.setScene(new Scene(root, 200, 250));
      stage.show();
  }
}