import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class Resizing_Components_in_the_Scroll_Pan extends Application {
    @Override
    public void start(Stage stage) {
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        
        VBox root = new VBox();
        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        
        scrollPane.setContent(browser);
        webEngine.loadContent("<b>asdf</b>");
        
        root.getChildren().addAll(scrollPane);
        scene.setRoot(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}