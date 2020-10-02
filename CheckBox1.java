import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CheckBox1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage){
    
        Scene scene = new Scene(new Group());
        stage.setTitle("ToolTip Sample");
        stage.setWidth(300);
        stage.setHeight(150);
        final CheckBox cb = new CheckBox("checkBox");
        final Tooltip tooltip = new Tooltip("$ tooltip");
        tooltip.setFont(new Font("Arial",16));
        cb.setTooltip(tooltip);
        cb.selectedProperty().addListener(new ChangeListener<Boolean>(){
        
            public void changed(ObservableValue<? extends Boolean>  ov,
            Boolean old_val,Boolean new_val){
                System.out.println(cb.isSelected());
            }
        });
        ((Group)scene.getRoot()).getChildren().add(cb);
        
        stage.setScene(scene);
        stage.show();
    }
}