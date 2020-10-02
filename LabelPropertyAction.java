import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class LabelPropertyAction extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
      
      Scene scene = new Scene(new Group());
      stage.setTitle("Label ");
      stage.setWidth(400);
      stage.setHeight(180);
      
      HBox hbox = new HBox();
      
      Label label1 = new Label("Search");
      label1.setText("Search long long long long long long long long long ");
      label1.setPrefWidth(100);
      label1.setWrapText(true);
      label1.setFont(new Font("Arial",10));
      label1.setTextFill(Color.web("#0076a3"));
      label1.setRotate(270);
      label1.setTranslateY(50);
      label1.setTranslateX(50);
      /*
       Label label1 = new Label("Name");
       Image image = new Image(getClass().getResourceAsStream("icon.jpg"));
       label1.setGraphic(new ImageView(image));
       label1.setTextFill(Color.web("#FF76a3"));
       */
      
      label1.setOnMouseEntered(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e){
            label1.setScaleX(1.5);
            label1.setScaleY(1.5);
        }
        });
        label1.setOnMouseExited(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e){
            label1.setScaleX(1);
            label1.setScaleY(1);
        }
        });
        
      hbox.setSpacing(10);
      hbox.getChildren().add(label1);
      ((Group) scene.getRoot()).getChildren().add(hbox);
      stage.setScene(scene);
      stage.show();
      
    }
}