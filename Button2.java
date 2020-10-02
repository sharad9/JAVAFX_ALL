import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Button2 extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
      Scene scene = new Scene(new Group());
      stage.setTitle("Button Sample");
      stage.setWidth(300);
      stage.setHeight(190);
      DropShadow shadow = new DropShadow();
      VBox vbox = new VBox();
      vbox.setLayoutX(20);
      vbox.setLayoutY(20);
      /*
       * Image imageOk = new Image(getClass().getResourceAsStream("OK.png"));
       * Button button = new Button("OK", new ImageView(imageOk));
       * Image okImage = new Image(getClass().getResourceAsStream("OK.png"));
       * button.setGraphic(new ImageView(okImage));
       */
      final Button b = new Button("Accept");
      b.setStyle("-fx-font: 30 arial; -fx-base:#ee2211");
      b.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e){
            b.setEffect(shadow);
        }
        }
      );
      b.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e){
            b.setEffect(null);
        }
        }
      );
      
      vbox.getChildren().add(b);
      vbox.setSpacing(10);
      ((Group)scene.getRoot()).getChildren().add(vbox);
      
      stage.setScene(scene);
      stage.show();
    }
}