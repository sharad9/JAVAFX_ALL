import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Rectangles extends Application{
    public static void main(String args []){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("");
        Group root = new Group();
        Scene scene = new Scene(root , 300 , 250 , Color.WHITE);
        
        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        
        root.getChildren().add(r);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    
    }
}
