import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Circle1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CIRCLE");
        Group root = new Group();
        Scene scene = new Scene(root, 550, 250,Color.web("0x00FFFF"));

        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);
        
        root.getChildren().add(circle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}