import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
public class EllipsesSubtract extends Application {
    public static void main(String[] args) {
        Application.launch(args);//from   w  w w  .  ja v  a  2  s. co m
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.WHITE);
        
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4,0.4,0.5));
        
        
        Ellipse ellipse1 = new Ellipse();
        ellipse1.setCenterX(100.0f);
        ellipse1.setCenterY(100.0f);
        ellipse1.setRadiusX(50.0f);
        ellipse1.setRadiusY(35.0f);
        ellipse1.setStrokeWidth(5);
        ellipse1.setStroke(Color.BLACK);
        ellipse1.setEffect(ds);
        
     
      
        
        Ellipse ellipse2 = new Ellipse();
        ellipse2.setCenterX(100.0f);
        ellipse2.setCenterY(100.0f);
        ellipse2.setRadiusX(16.0f);
        ellipse2.setRadiusY(13.0f);
        ellipse2.setStroke(Color.BLACK);
        ellipse2.setStrokeWidth(5);
        ellipse2.setEffect(ds);

        Shape shape = Path.subtract(ellipse1,ellipse2);
        shape.setStrokeWidth(1);
        shape.setStroke(Color.BLACK);
        shape.setEffect(ds);
        shape.setFill(Color.rgb(255,255,0));
        
        root.getChildren().add(shape);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
}