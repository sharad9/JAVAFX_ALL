import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
public class AccordionTitledPane3 extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
    Group g = new Group();
    Scene scene = new Scene(g, 550, 250);
    
    TitledPane t1 = new TitledPane("T1",new Button("B1"));
    TitledPane t2 = new TitledPane("T2",new Button("B2"));
    TitledPane t3 = new TitledPane("T3",new Button("B3"));
    
    Accordion accordion = new Accordion();
    accordion.getPanes().addAll(t1,t2,t3);
    
    g.getChildren().add(accordion);
    
    stage.setScene(scene);
    stage.show();
    
}
}