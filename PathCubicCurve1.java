import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.Group;
import javafx.stage.Stage;


public class PathCubicCurve1 extends Application{
    public static void main(String args[]){
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
    stage.setTitle("ComboBox Sample");
    Scene scene = new Scene(new Group(),500,300);
    
    Path path = new Path();
    
    MoveTo moveTo = new MoveTo();
    moveTo.setX(0.0f);
    moveTo.setY(0.0f);
    
    CubicCurveTo cubicTo = new CubicCurveTo();
    cubicTo.setControlX1(0.0f);
    cubicTo.setControlY1(0.0f);
    cubicTo.setControlX2(100.0f);
    cubicTo.setControlY2(100.0f);
    cubicTo.setX(100.0f);
    cubicTo.setY(50.0f);
    
    path.getElements().add(moveTo);
    path.getElements().add(cubicTo);
    
    Group root = (Group) scene.getRoot();
    root.getChildren().add(path);
    stage.setScene(scene);
    stage.show();
    }
}