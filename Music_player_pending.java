
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author Dean Iverson
 */
public class Music_player_pending extends Application {

  private final AudioClip coffeeClip;
  private final AudioClip jobClip;
  private final AudioClip meetingClip;
  private Slider volumeSlider;
  private Slider rateSlider;
  private Slider balanceSlider;

  public static void main(String[] args) {
    Music_player_pending.launch(args);
  }
  
  public Music_player_pending() {
    coffeeClip = new AudioClip(getClipResourceString("resources/coffee.mp3"));
    jobClip = new AudioClip(getClipResourceString("resources/job.mp3"));
    meetingClip = new AudioClip(getClipResourceString("resources/meeting.mp3"));
  }

  @Override
  public void start(Stage primaryStage) {
    final GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(5);

    createControls(grid);
    createClipList(grid);
    
    final Scene scene = new Scene(grid, 640, 380);
    scene.getStylesheets().add(getClass().getResource("media.css").toString());

    primaryStage.setTitle("AudioClip Example");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void createControls(GridPane grid) {
    final Label volumeLabel = new Label("Volume");
    final Label rateLabel = new Label("Rate");
    final Label balanceLabel = new Label("Balance");

    GridPane.setHalignment(volumeLabel, HPos.CENTER);
    GridPane.setHalignment(rateLabel, HPos.CENTER);
    GridPane.setHalignment(balanceLabel, HPos.CENTER);
    
    volumeSlider = new Slider(0.0, 1.0, 1.0);
    rateSlider = new Slider(0.25, 2.5, 1.0);
    balanceSlider = new Slider(-1.0, 1.0, 0.0);

    GridPane.setHgrow(volumeSlider, Priority.ALWAYS);
    GridPane.setHgrow(rateSlider, Priority.ALWAYS);
    GridPane.setHgrow(balanceSlider, Priority.ALWAYS);

    grid.add(volumeLabel, 0, 2);
    grid.add(volumeSlider, 0, 3);
    grid.add(rateLabel, 1, 2);
    grid.add(rateSlider, 1, 3);
    grid.add(balanceLabel, 2, 2);
    grid.add(balanceSlider, 2, 3);
  }

  private void createClipList(GridPane grid) {
    final VBox vbox = new VBox(30);
    vbox.setAlignment(Pos.TOP_CENTER);

    final Label clipLabel = new Label("Code Monkey To-Do List:");
    clipLabel.setId("clipLabel");

    
    final Button getUpButton = new Button("Get Up, Get Coffee");
    getUpButton.setPrefWidth(300);
    getUpButton.setOnAction(createPlayHandler(coffeeClip));

    final Button goToJobButton = new Button("Go to Job");
    goToJobButton.setPrefWidth(300);
    goToJobButton.setOnAction(createPlayHandler(jobClip));

    final Button meetingButton = new Button("Have Boring Meeting");
    meetingButton.setPrefWidth(300);
    meetingButton.setOnAction(createPlayHandler(meetingClip));

    final Hyperlink link = new Hyperlink("About Code Monkey...");
    link.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        WebView wv = new WebView();
        wv.getEngine().load("http://www.jonathancoulton.com/2006/04/14/" + 
                            "thing-a-week-29-code-monkey/");

        Scene scene = new Scene(wv, 720, 480);

        Stage stage = new Stage();
        stage.setTitle("Code Monkey");
        stage.setScene(scene);
        stage.show();
      }
    });

    vbox.getChildren().addAll(clipLabel, getUpButton, goToJobButton, 
                              meetingButton, link);
    
    GridPane.setHalignment(vbox, HPos.CENTER);
    GridPane.setHgrow(vbox, Priority.ALWAYS);
    GridPane.setVgrow(vbox, Priority.ALWAYS);
    grid.add(vbox, 0, 0, GridPane.REMAINING, 1);
  }

  private String getClipResourceString(String clipName) {
    return getClass().getResource(clipName).toString();
  }

  private EventHandler<ActionEvent> createPlayHandler(final AudioClip clip) {
    return new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        clip.play(volumeSlider.getValue(), balanceSlider.getValue(), 
                  rateSlider.getValue(), 0, 0);
      }
    };
  }
}