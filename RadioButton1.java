import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RadioButton1 extends Application {
  @Override
  public void start(Stage stage) {
      HBox root = new HBox();
      Scene scene = new Scene(root, 300, 150);
      stage.setScene(scene);
      stage.setTitle("");
      
      ToggleGroup group = new ToggleGroup();
      /*
       Image image = new Image(getClass().getResourceAsStream("Size.jpg"));
       RadioButton rb = new RadioButton("Size 9");
       rb.setGraphic(new ImageView(image));
       */
      RadioButton b1 = new RadioButton("select first");
      b1.setToggleGroup(group);
      b1.setSelected(true);
      RadioButton b2 = new RadioButton("select second");
      b2.setToggleGroup(group);
      
      root.getChildren().addAll(b1,b2);
      scene.setRoot(root);
      stage.show();

      
    }
     public static void main(String[] args) {
    launch(args);
  }
}


