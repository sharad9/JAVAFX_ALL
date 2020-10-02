import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Ellipses extends Application{
    public static void main(String args []){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("");
        Group root = new Group();
        Scene scene = new Scene(root,300,250,Color.WHITE);
        
        Group g = new Group();
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4,0.4,0.5));
        
        
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(50.0f);
        ellipse.setCenterY(50.0f);
        ellipse.setRadiusX(50.0f);
        ellipse.setRadiusY(50.0f);
        ellipse.setEffect(ds);
        
        g.getChildren().add(ellipse);
        
        root.getChildren().add(g);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
} 