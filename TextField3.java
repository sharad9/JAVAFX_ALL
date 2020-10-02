import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextField3 extends Application{
    StringProperty title = new SimpleStringProperty();
    public static void main(String[] args) {
        Application.launch(args);
    }

     @Override 
    public void start(Stage stage){
        TextField tf = new TextField();
        tf.setText("Stage Coach");
        tf.setPrefColumnCount(15);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().add(new Label("title"));
        hbox.getChildren().add(tf);

        Scene scene = new Scene(hbox,300,300);
        title.bind(tf.textProperty());

        stage.setScene(scene);
        stage.titleProperty().bind(title);
        stage.show();
    }
}