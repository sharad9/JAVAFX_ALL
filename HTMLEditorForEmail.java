import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
public class HTMLEditorForEmail extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Message Composing");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene (new Group());
        
        final VBox root = new VBox();
        root.setPadding(new Insets(8,8,8,8));
        root.setSpacing(5);
        root.setAlignment(Pos.BOTTOM_LEFT);
        
        final GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);
        
        final ChoiceBox sendTo = new ChoiceBox(FXCollections.observableArrayList(
                "To:","Cc:","Bcc:"));
                
        sendTo.setPrefWidth(100);
        GridPane.setConstraints(sendTo, 0, 0);
        grid.getChildren().add(sendTo);
        
        final TextField tfTo = new TextField();
        tfTo.setPrefWidth(400);
        GridPane.setConstraints(tfTo,1,0);
        grid.getChildren().add(tfTo);
        
        final Label subLb = new Label("Subjects:");
        GridPane.setConstraints(subLb,0,1);
        grid.getChildren().add(subLb);
        
        final TextField tfSub = new TextField();
        tfSub.setPrefWidth(400);
        GridPane.setConstraints(tfSub,1,1);
        grid.getChildren().add(tfSub);
        
        root.getChildren().add(grid);
        
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(400);
        
        root.getChildren().addAll(htmlEditor, new Button("Send"));
        
        final Label htmlLabel = new Label();
        htmlLabel.setWrapText(true);
        
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
