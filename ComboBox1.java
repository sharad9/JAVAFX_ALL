import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class ComboBox1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 500, 300);
        GridPane gridPane = new GridPane();
        
        
        ComboBox<String> cb = new ComboBox<String>();
        /*
        ComboBox<Rectangle> cb = new ComboBox<Rectangle>();
        cb.getItems().addAll(
            new Rectangle(10, 10, Color.RED),
            new Rectangle(10, 10, Color.GREEN),
            new Rectangle(10, 10, Color.BLUE)
        );
        
        
        */
        cb.getItems().addAll("A","B","C","D");
        cb.setValue("A");
        cb.setValue(null);
        //cb.getValue();
        cb.setPromptText("Email Address");
        
        cb.setEditable(true);
         
        cb.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
          @Override
          public ListCell<String> call(ListView<String> param) {
            final ListCell<String> cell = new ListCell<String>() {
              {
                super.setPrefWidth(100);
              }

              @Override
              public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                  setText(item);
                  if (item.contains("A")) {
                    setTextFill(Color.RED);
                  } else if (item.contains("B")) {
                    setTextFill(Color.GREEN);
                  } else {
                    setTextFill(Color.BLACK);
                  }
                } else {
                  setText(null);
                }
              }
            };
            return cell;
          }
        });
       
        gridPane.add(cb,2,0);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.show();

    }
}