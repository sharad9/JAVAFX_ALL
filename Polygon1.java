import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
public class Polygon1 extends Application {

  @Override
  public void start(Stage stage) {
      Group root = new Group();
      Scene scene = new Scene(root,200,300);
      stage.setScene(scene);
      
      Group g = new Group();
      Polygon polygon = new Polygon();
      polygon.getPoints().addAll(new Double []{
        0.0,0.0,
        20.0,10.0,
        10.0,20.0
        });
        
      g.getChildren().add(polygon);
      
      scene.setRoot(g);
      stage.show();
      
    }
    
  public static void main(String [] args){
      launch(args);
    }  
}