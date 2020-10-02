import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WebColor extends Application{
    public static void main(String args []){
    launch(args);
    }
    @Override
    public void start(Stage stage){
        Scene scene = new Scene (new Group());
        stage.setTitle("Label Color Sample");
        stage.setWidth(400);
        stage.setHeight(180);
        
        HBox hbox = new HBox();
        Label label1 = new Label("Search");
        label1.setTextFill(Color.web("#0076a3"));
        
        hbox.setSpacing(10);
        hbox.getChildren().add(label1);
        ((Group) scene.getRoot()).getChildren().add(hbox);
        
        stage.setScene(scene);
        stage.show();
        
    }
}