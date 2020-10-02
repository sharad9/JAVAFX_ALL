import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextRgb extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Drawing Text");
        Group root = new Group();
        Scene scene = new Scene(root,300,250,Color.WHITE);
        int x = 100;
        int y = 100;
        int red = 30;
        int green = 40;
        int blue = 50;
        
        Text text = new Text(x,y,"Wakka woiooi");
        text.setFill(Color.rgb(red,green,blue,0.99));
        text.setRotate(60);
        root.getChildren().add(text);
        
        stage.setScene(scene);
        stage.show();
    }


}