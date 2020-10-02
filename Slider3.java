import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Slider3 extends Application{
    final Slider opacityLevel = new Slider(0, 1, 1);
    final Label opacityCaption = new Label("Opacity Level");
    final Label opacityValue = new Label(Double.toString(opacityLevel.getValue()));
    
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(70);
        
        scene.setRoot(grid);
        
        GridPane.setConstraints(opacityCaption,0,1);
        grid.getChildren().add(opacityCaption);
        
        opacityLevel.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number>ov,
            Number old_val,Number new_val){
                System.out.println(new_val.doubleValue());
                opacityValue.setText(String.format("%.2f",new_val));
            }
        });
        
        GridPane.setConstraints(opacityLevel,1,1);
        grid.getChildren().add(opacityLevel);
        
        GridPane.setConstraints(opacityValue,2,1);
        grid.getChildren().add(opacityValue);
        
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}