import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import jdk.nashorn.api.scripting.JSObject;

public class Main1 extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    WebEngine webEngine = new WebEngine();
    webEngine.getLoadWorker().stateProperty()
        .addListener((obs, oldValue, newValue) -> {
          if (newValue == Worker.State.SUCCEEDED) {

            JSObject jsobj = (JSObject) webEngine.executeScript("window");
            jsobj.setMember("ABCD", new HelloWorld1());
          }
        });

    webEngine.load("http://www.java2s.com");

    Group root = new Group();
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

class HelloWorld1 {
  public String sayGoodbye(String name) {
    return "hi:" + name;
  }
}