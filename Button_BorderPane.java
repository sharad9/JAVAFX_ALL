import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/*from w  ww  .ja va2 s  . com*/
public class Button_BorderPane extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }
  @Override
   public void start(Stage stage) {
    stage.setTitle("BorderPane Test");
    BorderPane bp = new BorderPane();
    bp.setPadding(new Insets(10,20,10,20));
    
    Button btnTop= new Button("TOP");
    bp.setTop(btnTop);
    
    Button btnLeft= new Button("Left");
    bp.setLeft(btnLeft);
    
    Button btnCenter= new Button("Center");
    bp.setCenter(btnCenter);
    
    Button btnBottom= new Button("Bottom");
    bp.setBottom(btnBottom);
    
    Scene scene = new Scene(bp,300,200);
    stage.setScene(scene);
    stage.show();
    
    
    
  
  
}
}
