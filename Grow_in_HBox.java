import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Grow_in_HBox extends Application{
    public static void main(String args[]){
        Application.launch(args);
        
    }
    @Override
    public void start(Stage stage){
        stage.setTitle("Grow in HBox");
        Group root = new Group();
        Scene scene = new Scene(root,300,300,Color.WHITE);
        
        HBox hbox = new HBox(35);//space
        Button button1 = new Button("Add                   ");
        Button button2 = new Button("Remove ");
        HBox.setHgrow(button1,Priority.ALWAYS);
        HBox.setHgrow(button2,Priority.ALWAYS);
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        hbox.getChildren().addAll(button1,button2);
        
        //Set Preferred Width for HBox
        hbox.setPrefWidth(400);
        
        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
    
}