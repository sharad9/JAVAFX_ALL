import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
//w w  w . j av  a2  s .co  m
public class ComboBox2 extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(final Stage primaryStage) {
    Group root = new Group();
    Scene scene = new Scene(root, 400, 300, Color.WHITE);
    GridPane gridpane = new GridPane();
    ComboBox<Color> cmb = new ComboBox<Color>();
    cmb.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
    cmb.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
      @Override
      public ListCell<Color> call(ListView<Color> p) {
        return new ListCell<Color>() {
          private final Rectangle rectangle;
          {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            rectangle = new Rectangle(10, 10);
          }

          @Override
          protected void updateItem(Color item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
              setGraphic(null);
            } else {
              rectangle.setFill(item);
              setGraphic(rectangle);
            }
          }
        };
      }
    });

    gridpane.add(cmb, 2, 0);

    root.getChildren().add(gridpane);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

}