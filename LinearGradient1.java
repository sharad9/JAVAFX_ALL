import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LinearGradient1 extends Application{
    @Override
    public void start(Stage stage){
        VBox box = new VBox();
        final Scene scene = new Scene(box,300,250);
        scene.setFill(null);

        Stop stops[] = new Stop[]{new Stop(0,Color.BLACK),new Stop(1,Color.RED)};
        LinearGradient lg1 = new LinearGradient(
            0,//startX
            0,//startY
            1,//endX
            0,//endY
      
            true,//proportional
            CycleMethod.NO_CYCLE,stops);
        
        Rectangle r1 = new Rectangle(0,0,700,700);
        r1.setFill(lg1);
        
        box.getChildren().add(r1);
        
        stage.setScene(scene);
        stage.show();
        

    }
     public static void main(String[] args) {
        launch(args);
    }
}
