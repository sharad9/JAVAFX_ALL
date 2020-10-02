import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
/*from  w  w  w. j a va 2  s.  c  om*/
public class ProgressIndicator1 extends Application {

  @Override
  public void start(Stage stage) {
    Group root = new Group();
    Scene scene = new Scene(root, 260, 80);
    stage.setScene(scene);

    Group g = new Group();

    ProgressIndicator p1 = new ProgressIndicator();
    p1.setProgress(0.25F);
    
    g.getChildren().add(p1);
    
    scene.setRoot(g);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}