import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/*from   ww w . j a  v a 2s  .  c  o  m*/
public class TitledPane2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 450, 250);
        TitledPane tp = new TitledPane("Select",new CheckBox("OK"));
        tp.setCollapsible(false);
        tp.setAnimated(false);
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20,0,0,20));
        hbox.getChildren().setAll(tp);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(hbox);
        
        stage.setScene(scene);
        stage.show();

    }
}