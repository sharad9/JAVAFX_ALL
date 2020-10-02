import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorPicker1 extends Application{
    public static void main(String args []){
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new HBox(20), 400, 100);
        HBox box = (HBox)scene.getRoot();
        /*
         ObservableList<Color> customColors = colorPicker.getCustomColors();
         colorPicker.setValue(customColors.get(index)); 
         
         */
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);
        final Text text = new Text("Color Picker");
        text.setFill(colorPicker.getValue());
        colorPicker.setOnAction((ActionEvent t)->{
            text.setFill(colorPicker.getValue());
        });
        
        box.getChildren().addAll(colorPicker, text);
        
        stage.setScene(scene);
        stage.show();
    }
}