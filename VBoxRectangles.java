import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VBoxRectangles extends Application{
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root,300,300);
        // 5 pixels space between child nodes
        VBox vBox = new VBox(5);
        // 1 pixel padding between child nodes only
        vBox.setPadding(new Insets(1));
        Rectangle r1 = new Rectangle(10,10);
        Rectangle r2 = new Rectangle(20,100);
        Rectangle r3 = new Rectangle(50,20);
        Rectangle r4 = new Rectangle(20,50);
        
        VBox.setMargin(r1,new Insets(2,2,2,2));
        
        vBox.getChildren().addAll(r1,r2,r3,r4);
        root.getChildren().add(vBox);
        
        stage.setScene(scene);
        stage.show();
        
        
    
    }
    public static void main(String[] args) {
    launch(args);
  }

}