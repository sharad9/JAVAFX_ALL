import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Separator1 extends Application{

    Label caption = new Label("WE");
    
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(2);
        grid.setHgap(5);
        
        scene.setRoot(grid);
        
        caption.setFont(Font.font("Verdana", 30));
        
        GridPane.setConstraints(caption, 0 , 0);
        GridPane.setColumnSpan(caption, 8);
        grid.getChildren().add(caption);
        
        final Separator sp = new Separator();
        sp.setValignment(VPos.CENTER);
        GridPane.setConstraints(sp, 0, 1);
        GridPane.setColumnSpan(sp, 20);
        grid.getChildren().add(sp);
        
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

