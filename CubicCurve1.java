import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;

public class CubicCurve1 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
      stage.setTitle("Cubic Curve");
      Scene scene = new Scene(new Group(),450,250);
      
      CubicCurve cubic = new CubicCurve();
      cubic.setStartX(0.0f);
      cubic.setStartY(50.0f);
      cubic.setControlX1(25.0f);
      cubic.setControlY1(0.0f);
      cubic.setControlX2(75.0f);
      cubic.setControlY2(100.0f);
      cubic.setEndX(100.0f);
      cubic.setEndY(50.0f);
      
      Group root = (Group)scene.getRoot();
      root.getChildren().add(cubic);
      stage.setScene(scene);
      stage.show();
      
    }
} 