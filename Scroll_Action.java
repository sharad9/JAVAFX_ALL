import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Scroll_Action extends Application{
    public static void main(String args []){
    launch(args);
    }
    
    @Override
    public void start (Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        
        
        Rectangle rect = new Rectangle(200,200,Color.RED);
        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120,120);
        s1.setContent(rect);
        
        s1.vvalueProperty().addListener( new ChangeListener<Number> (){
            public void changed(ObservableValue<? extends Number> ov,
            Number old_val,Number new_val){
                System.out.println(new_val.intValue());
                
            }
        
        });
        
        s1.hvalueProperty().addListener( new ChangeListener<Number> (){
            public void changed(ObservableValue<? extends Number> ov,
            Number old_val,Number new_val){
                System.out.println(new_val.intValue());
                
            }
        
        });
        
        root.getChildren().add(s1);
        stage.show();
    
    }

}