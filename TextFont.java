import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextFont extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Title");
        
        final Circle c = new Circle(40,40,30);
        final Group root = new Group(c);
        final Scene scene = new Scene(root,600,700,Color.hsb(270,1.0,1.0,1.0));
        final Text  text = new Text(25,25,"jo chal gaya");
        text.setFill(Color.DARKBLUE);
        text.setFont(Font.font(java.awt.Font.SERIF,25));
       
        
        Text text2 = new Text(50, 100, "Java fgdhfgh gh");
        Font sanSerif = Font.font("Duming ulla",30);
        
        text.setFont(sanSerif);
        text.setFill(Color.BEIGE);
        
        root.getChildren().add(text);
        root.getChildren().add(text2);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
}