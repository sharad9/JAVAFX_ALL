import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Polyline1 extends Application{
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root,260,80);
        stage.setScene(scene);
        
        Group g = new Group();
        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(new Double[] {
            0.0,0.0,
            20.0,10.0,
            10.0,20.0
        });
        
        g.getChildren().add(polyline);
        scene.setRoot(g);
        stage.show();
        
    }
    
    public static void main(String args[]){
    launch(args);
    }
}