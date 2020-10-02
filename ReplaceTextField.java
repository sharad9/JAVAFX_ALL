import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
// w  w w. j  a  va2  s .co m
public class ReplaceTextField extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
      Group root = new Group();
      Scene scene = new Scene(root, 300, 300, Color.WHITE);
      
      TextField tf = new TextField(){
      @Override
      public void replaceText(int start, int end, String text){
          if(!text.matches("[a-z]")){
            super.replaceText(start,end,text);
            
            }
        
        }
        
        @Override
        public void replaceSelection(String text){
            if(!text.matches("[a-z]")){
                super.replaceSelection(text);
            }
        }
    
    };
    root.getChildren().add(tf);
    stage.setScene(scene);
    stage.show();
}
}
