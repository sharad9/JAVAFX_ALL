import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class SetPaddingAndSpacingVBox extends Application{
    public static void main(String args []){
    Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
    stage.setTitle("vbox Text");
    
    //vbox
    VBox vb = new VBox();
    vb.setPadding(new Insets(15,12,15,12));
    vb.setSpacing(10);
    
    Label lbl = new Label("VBox Test");
    lbl.setFont(Font.font("Amble CN",FontWeight.BOLD,24));
    vb.getChildren().add(lbl);
    //Buttons
    
    Button btn1 = new Button();
    btn1.setText("Button1");
    vb.getChildren().add(btn1);
    
    Button btn2 = new Button();
    btn2.setText("Button1");
    vb.getChildren().add(btn2);
    
    Button btn3 = new Button();
    btn3.setText("Button1");
    vb.getChildren().add(btn3);
    
    Button btn4 = new Button();
    btn4.setText("Button1");
    vb.getChildren().add(btn4);
    
    //Adding vbox to the scene
    Scene scene = new Scene(vb);
    stage.setScene(scene);
    stage.show();
    }
}