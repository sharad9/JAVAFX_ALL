import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Pannable_ScrollPane extends Application{

    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        
        Rectangle rect = new Rectangle(200, 200, Color.RED);
        ScrollPane s1 = new ScrollPane();
        s1.setPannable(true);
        s1.setPrefSize(120,120);
        s1.setContent(rect);
        
        root.getChildren().add(s1);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}