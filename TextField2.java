import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
public class TextField2 extends Application{
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Text Field Sample");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        scene.setRoot(grid);

        final TextField name = new TextField();
        name.setPromptText("Enter your first name:");
        name.setPrefColumnCount(10);
        name.getText();

        GridPane.setConstraints(name , 2 ,5);
        grid.getChildren().add(name);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}