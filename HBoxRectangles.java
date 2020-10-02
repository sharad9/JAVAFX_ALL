import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HBoxRectangles extends Application{
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root,300,300);
        // 5 pixels space between child nodes
        HBox hbox = new HBox(5);
        // 1 pixel padding between child nodes only
        hbox.setPadding(new Insets(1));
        Rectangle r1 = new Rectangle(10,10);
        Rectangle r2 = new Rectangle(20,100);
        Rectangle r3 = new Rectangle(50,20);
        Rectangle r4 = new Rectangle(20,50);
        
        HBox.setMargin(r1,new Insets(2,2,2,2));
        hbox.getChildren().addAll(r1,r2,r3,r4);
        root.getChildren().add(hbox);
        
        stage.setScene(scene);
        stage.show();
        
        
    
    }
    public static void main(String[] args) {
    launch(args);
  }

}