import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordField1 extends Application{

    final Label mssg = new Label("");

    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene (root, 260, 100);
        stage.setScene(scene);
        stage.setTitle("Password Field Sample");

        VBox vb = new VBox();
        vb.setPadding(new Insets(10,0,0,10));
        vb.setSpacing(10);

        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER_LEFT);
        Label label = new Label("Password");
        final PasswordField pf = new PasswordField();

        pf.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e){
                    if(!pf.getText().equals("abc")){
                        mssg.setText("Your Password is Incorrect");
                        mssg.setTextFill(Color.web("red"));
                    }else{
                        mssg.setText("Your pass word is confirmed");
                        mssg.setTextFill(Color.web("black"));
                    }
                    pf.setText("");


                }
            });
        hb.getChildren().addAll(label,pf);
        vb.getChildren().addAll(hb,mssg);
        scene.setRoot(vb);
        stage.show();

    }
    public static void main(String args[]){
        launch(args);
    }
}
