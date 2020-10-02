import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//from w  w w . j ava2 s  .  c  o m
public class RadioButton2 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(new Group());
    stage.setWidth(250);
    stage.setHeight(150);

    final ToggleGroup group = new ToggleGroup();
    /*
     * Image image = new Image(getClass().getResourceAsStream("Size.jpg"));
     * RadioButton rb = new RadioButton("Size 9");
r      b.setGraphic(new ImageView(image));
     */
    RadioButton rb1 = new RadioButton("A");
    rb1.setToggleGroup(group);
    rb1.setUserData("A");

    RadioButton rb2 = new RadioButton("B");
    rb2.setToggleGroup(group);
    rb2.setUserData("B");

    RadioButton rb3 = new RadioButton("C");
    rb3.setToggleGroup(group);
    rb3.setUserData("C");
    rb3.setSelected(true);
    rb3.requestFocus();
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (group.getSelectedToggle() != null) {
          System.out.println(group.getSelectedToggle().getUserData().toString());
        }
      }
    });

    HBox hbox = new HBox();
    VBox vbox = new VBox();

    vbox.getChildren().add(rb1);
    vbox.getChildren().add(rb2);
    vbox.getChildren().add(rb3);
    vbox.setSpacing(10);

    hbox.getChildren().add(vbox);
    hbox.setSpacing(50);
    hbox.setPadding(new Insets(20, 10, 10, 20));

    ((Group) scene.getRoot()).getChildren().add(hbox);
    stage.setScene(scene);
    stage.show();
  }
}