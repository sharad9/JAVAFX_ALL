import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPane_for_two_columns extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
      stage.setTitle("");
      FlowPane flowPane = new FlowPane();
      flowPane.setPadding(new Insets(10,10,10,10));
      flowPane.setVgap(4);
      flowPane.setHgap(4);
      flowPane.setPrefWrapLength(210);
      
      Button btn;
      for (int i = 0;i<8;i++){
        btn = new Button("Button"+i);
        btn.setPrefSize(100,50);
        flowPane.getChildren().add(btn);
        }
      
      Scene scene = new Scene(flowPane);
      stage.setScene(scene);
      stage.show();
        
      
      
    }
}