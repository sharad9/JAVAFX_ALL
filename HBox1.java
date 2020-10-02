import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HBox1 extends Application{
    @Override
    public void start(Stage stage){
        TextField myTextField = new TextField();
        HBox hbox = new HBox();
        hbox.getChildren().add(myTextField);
        HBox.setHgrow(myTextField,Priority.ALWAYS);
        
        Scene scene = new Scene(hbox,300,200,Color.rgb(0,0,0,0));
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args []){
    launch(args);
    }
    
}    
