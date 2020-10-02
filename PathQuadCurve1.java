import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

public class PathQuadCurve1 extends Application{
    @Override
    public void start(Stage stage){
    
        Group root = new Group();
        Scene scene = new Scene(root,300,150);
        stage.setScene(scene);
        stage.setTitle("Curve");
        
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(0.0f);
        moveTo.setY(50.0f);
        
        QuadCurveTo quadTo = new QuadCurveTo();
        quadTo.setControlX(25.0f);
        quadTo.setControlY(250.0f);
        quadTo.setX(50.0f);
        quadTo.setY(50.0f);
        
        path.getElements().add(moveTo);
        path.getElements().add(quadTo);
        
        
       root.getChildren().add(path);
       
       scene.setRoot(root);
       stage.show();
        
        
    }
    
    public static void main(String args []){
        launch(args);
    }
}
