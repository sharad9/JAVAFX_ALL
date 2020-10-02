import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ScrollPane1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage){
    stage.setWidth(500);
    stage.setHeight(500);
    Scene scene = new Scene(new Group());
    
    VBox root = new VBox();
    
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(browser);
    webEngine.loadContent("<html><body><b>asdf</b></body></html>");
    /*
    Image img = new Image(getClass().getResourceAsStream("D:/THONY Programs/corona.jpeg"));
    ScrollPane sp = new ScrollPane();
    sp.setContent(new ImageView(img));
    */
    root.getChildren().addAll(scrollPane);
    scene.setRoot(root);
    
    stage.setScene(scene);
    stage.show();
}
    
}