import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Adding_Buttons_to_flow_pane extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("HTML");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        
        FlowPane flow = new FlowPane();
        flow.setVgap(8);
        flow.setHgap(4);
        flow.setPrefWrapLength(300);//prefered width = 300
        for(int i = 0;i < 10; i++ ){
            flow.getChildren().add(new Button("Button"+i));
        }
        
        scene.setRoot(flow);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args []){
        launch(args);
    }
}