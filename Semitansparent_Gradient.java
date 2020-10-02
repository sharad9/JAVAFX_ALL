import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Semitansparent_Gradient extends Application {

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        final Scene scene = new Scene(box,300,250);
        scene.setFill(null);
        
        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(100);
        rectangle.setHeight(70);
        
        LinearGradient lg = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.1f,Color.rgb(25,200,0,0.4)),
                new Stop(1.0f,Color.rgb(0,0,0,0.1)));
                
        rectangle.setFill(lg);
        
        box.getChildren().add(rectangle);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
 
    }
