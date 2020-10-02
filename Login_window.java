import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login_window extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        stage.setTitle("JavaFX WELCOME");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        grid.add(scenetitle,0,0,2,1);
        
        Label userName = new Label("User Name");
        grid.add(userName,0,1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);
        
        Label pswd = new Label("Password:");
        grid.add(pswd,0,2);
        
        PasswordField pswdF = new PasswordField();
        grid.add(pswdF,1,2);
        
        Button SnInBtn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(SnInBtn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        SnInBtn.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent e){
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });
        
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
}
