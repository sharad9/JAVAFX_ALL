import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class HypperLink1 extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("HTML");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        VBox root = new VBox();
        Hyperlink link = new Hyperlink("www.java2s.com");
        link.setFont(Font.font("Arial",20));
        /*
         Hyperlink hpl = new Hyperlink("java2s.com");
         Image image1 = new Image(new File("a.jpg").toURI().toString(), 0, 100, false, false);
         hpl.setGraphic(new ImageView (image1));
         */
        link.setText("http://www.java2s.com");
        link.setOnAction((ActionEvent e)->{
            System.out.println("This link is Clicked");
        });
        root.getChildren().addAll(link);
        scene.setRoot(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String args[]){
        launch(args);
    }
}