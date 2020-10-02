import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UpdateLabelActon extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
      Button btn = new Button();
      final Label lbl = new Label();
      
      stage.setTitle("Hello World!");
      lbl.setLayoutX(70);
      lbl.setLayoutY(150);
      
      btn.setLayoutX(100);
      btn.setLayoutY(100);
      btn.setText("Hello ,World!");
      
      btn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            lbl.setText("Hellooo, wororld ");
        }
        });
        
        Group root = new Group();
        root.getChildren().add(btn);
        root.getChildren().add(lbl);
        stage.setScene(new Scene(root,300,300));
        stage.show();
        
    }
}