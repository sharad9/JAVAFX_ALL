import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

public class Line2 extends Application{
    @Override 
    public void start(final Stage stage){
        stage.setTitle("HTML");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        
        
        VBox root = new VBox();
        
        Path path = new Path();
        path.getElements().add(new MoveTo(50.0f,0.0f));
        path.getElements().add(new VLineTo(40.0f));
        
        root.getChildren().addAll(path);
        scene.setRoot(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args []){
        launch(args);
    }

}