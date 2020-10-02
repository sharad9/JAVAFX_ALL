import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
public class ShadowCircle extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CIRCLE");
        Group root = new Group();
        Scene scene = new Scene(root, 550, 250,Color.web("0x00FFFF"));
        Group g = new Group();
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(10.0);
        ds.setColor(Color.color(0.4,0.4,0.5));
        
        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);
        circle.setEffect(ds);
        
        g.getChildren().add(circle);
        root.getChildren().add(g);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}