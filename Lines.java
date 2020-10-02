import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Lines extends Application{
    
    @Override
    public void start (Stage stage){
        VBox box = new VBox();
        final Scene scene = new Scene(box,500,250);
        scene.setFill(null);
        
        Line line = new Line();
        line.setStartX(100);
        line.setStartY(10);
        line.setEndX(10);
        line.setEndY(110);
        
        box.getChildren().add(line);
        
        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
       
        
    }
    public static void main(String args[]){
        launch(args);
    }
}
