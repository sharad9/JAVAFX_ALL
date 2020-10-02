import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooser1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage stage) {
        Group root = new Group();
        Button buttonLoad = new Button("Load");
        buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files(*.txt)","*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(stage);
                System.out.println(file);
            }
        });
        
        VBox vb = new VBox();
        vb.getChildren().add(buttonLoad);
        root.getChildren().add(vb);
        stage.setScene(new Scene(root, 500 , 500));
        stage.show();
    }
}