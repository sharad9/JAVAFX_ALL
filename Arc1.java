import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Arc1 extends Application{
    public static void main(String args []){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
        stage.setTitle("Arc");
        
        Group g = new Group();
        Scene scene = new Scene(g,500,350,Color.web("0x00FFFF",1.0));
        
        Arc arc = new Arc();
        arc.setCenterX(50.0f);
        arc.setCenterY(50.0f);
        arc.setRadiusX(25.0f);
        arc.setRadiusY(25.0f);
        arc.setStartAngle(45.0f);
        arc.setLength(270.0f);
        arc.setType(ArcType.ROUND);
        
        g.getChildren().add(arc);
        
        stage.setScene(scene);
        stage.show();
    }
}