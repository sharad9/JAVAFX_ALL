import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChoiceBox2 extends Application{
    ObservableList cursors = FXCollections.observableArrayList(
        Cursor.DEFAULT,
        Cursor.CROSSHAIR,
        Cursor.WAIT,
        Cursor.TEXT,
        Cursor.HAND,
        Cursor.MOVE,
        Cursor.N_RESIZE,
        Cursor.NE_RESIZE,
        Cursor.E_RESIZE,
        Cursor.SE_RESIZE,
        Cursor.SW_RESIZE,
        Cursor.W_RESIZE,
        Cursor.NW_RESIZE,
        Cursor.NONE
   
    );
    
    @Override
    public void start(Stage stage){
        ChoiceBox choiceBoxRef =new  ChoiceBox();
        choiceBoxRef.setItems(cursors);
        
        VBox box = new VBox();
        box.getChildren().add(choiceBoxRef);
        final Scene scene = new Scene(box, 300, 300);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
        scene.cursorProperty().bind(choiceBoxRef.getSelectionModel()
        .selectedItemProperty());
    }
    public static void main(String[] args) {
        launch(args);
    }
}