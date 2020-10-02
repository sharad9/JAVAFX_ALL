import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageView1 extends Application{

    public static void main(String args[]){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("Title");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        final ImageView imv = new ImageView();
        imv.setPreserveRatio(true);
        imv.setFitWidth(100);
        final Image image2 = new Image(ImageView1.class.getResourceAsStream("image.png"));
        imv.setImage(image2);
        imv.setRotate(90);
        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(imv);
        gridPane.add(pictureRegion,1,1);

        root.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.show();

        
    }
}