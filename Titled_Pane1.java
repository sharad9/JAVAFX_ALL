import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Titled_Pane1 extends Application{
    public static void main(String args []){
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group());
        TitledPane tp = new TitledPane("My Title",new CheckBox("OK"));
        
        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20,0,0,20));
        hbox.getChildren().setAll(tp);
        
        Group root = (Group) scene.getRoot();
        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
}
