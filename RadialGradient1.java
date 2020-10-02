import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class RadialGradient1 extends Application {
    static int dx = 1;
    static int dy = 1;
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
     public void start(final Stage stage) {
        stage.setTitle("Animation");
        Group root = new Group();
        Scene scene = new Scene(root,400,300,Color.WHITE);
        
        stage.setScene(scene);
        addBouncyBall(scene);
        stage.show();
    
}
    private void addBouncyBall(final Scene scene){
        final Circle ball = new Circle(100,100,200);
        
        RadialGradient gradient1 = new RadialGradient(0,
            .1,
            100,
            100,
            20,
            false,
            CycleMethod.NO_CYCLE,
            new Stop(0, Color.RED),
            new Stop(1, Color.BLACK));
            
        ball.setFill(gradient1);
        
        final Group root = (Group) scene.getRoot();
        root.getChildren().add(ball);
    
    }
    
}

