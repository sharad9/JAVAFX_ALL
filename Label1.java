import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Label1 extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Group root = new Group();
    Scene scene = new Scene(root, 300, 130, Color.LIME);

    GridPane gridpane = new GridPane();
    gridpane.setPadding(new Insets(50));
    gridpane.setHgap(10);
    gridpane.setVgap(10);

    Label label = new Label("Label");
    GridPane.setHalignment(label, HPos.CENTER);
    gridpane.add(label, 0, 0);

    root.getChildren().add(gridpane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
