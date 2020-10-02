import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.Reflection;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TextFont2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
     @Override
    public void start(Stage stage) {
        stage.setTitle("Title");
        final Circle circ = new Circle(50,50,50);
        final Group root = new Group(circ);
        
        final Scene scene = new Scene(root,800,500,Color.BEIGE);
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setColor(Color.color(0,1,1));
        
        Reflection r = new Reflection();
        r.setFraction(0.7);
        
        
        final Text t1 = new Text();
        t1.setCache(true);
        t1.setX(10.0);
        t1.setY(70.0);
        
        t1.setFill(Color.CHOCOLATE);
        t1.setText("ELEXA");
        t1.setFont(Font.font(null,FontWeight.BOLD,32));
        t1.setEffect(ds);
        t1.setEffect(r);
        root.getChildren().add(t1);
       
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
