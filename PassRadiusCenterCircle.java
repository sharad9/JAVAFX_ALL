import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PassRadiusCenterCircle extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Fonts");
       
        

        final Circle circle = new Circle(40,40,30);
        final Group root = new Group(circle);
        final Scene scene = new Scene(root,400,300);
        
        
    

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}