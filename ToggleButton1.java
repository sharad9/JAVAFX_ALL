import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.HBox;

public class ToggleButton1 extends Application{

    public static void main(String args[]){
        launch(args);
    } 

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group(),300,400);
        scene.getStylesheets().add("myStyle.css");
        ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("High");
        tb1.setToggleGroup(group);
        tb1.setSelected(true);

        ToggleButton tb2 = new ToggleButton("Medium");
        tb2.setToggleGroup(group);

        ToggleButton tb3 = new ToggleButton("Low");
        tb3.setToggleGroup(group);

        tb1.setUserData("High");
        tb2.setUserData("Medium");
        tb3.setUserData("Low");
        tb1.getStyleClass().add("toggle-button1");
        tb2.getStyleClass().add("toggle-button2");
        tb3.getStyleClass().add("toggle-button3");
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                public void changed(ObservableValue<? extends Toggle> ov,Toggle
                old_toggle,Toggle new_toggle){
                    if(new_toggle ==null)
                        System.out.println("default value");
                    else
                        System.out.println(group.getSelectedToggle().getUserData().toString());
                }    
            });
        HBox hbox = new HBox();
        hbox.getChildren().addAll(tb1, tb2, tb3);
        
        
        
        
        ((Group)scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
        
    }
}