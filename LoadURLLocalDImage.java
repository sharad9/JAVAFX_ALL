import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoadURLLocalDImage extends Application{
    @Override 
    public void start(Stage stage){
        try{

            File file = new File("D:/ALL JAVA/PROJECTS/image.png");
            String localUrl = file.toURI().toURL().toString();
            Image loaclImage = new Image(localUrl, false);

            String remoteUrl = "http://javas2.com/style/demo/FireFox.png";
            Image remoteImage = new Image(remoteUrl, true);

            System.out.println(localUrl);
            System.out.println(remoteUrl);
        }catch(MalformedURLException ex){

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}