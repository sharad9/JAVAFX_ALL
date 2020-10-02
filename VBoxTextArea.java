import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VBoxTextArea extends Application{

    @Override
    public void start (Stage stage){
        TextArea myTextArea = new TextArea();
        VBox hbox = new VBox();
        hbox.getChildren().add(myTextArea);
        VBox.setVgrow(myTextArea,Priority.ALWAYS);
        Scene scene = new Scene(hbox,300,200,Color.rgb(0,1,1,0.5));
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String args []){
        launch(args);
    }
}