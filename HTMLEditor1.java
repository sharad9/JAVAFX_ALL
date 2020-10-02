import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
public class HTMLEditor1 extends Application{
    private String initialText =  "Lorem ipsum dolor sit "
            + "amet, consectetur adipiscing elit.<i> Nam tortor felis</i>:, pulvinar "
            + "<UL><li>a</li><li>b</li><li>c</li></UL>"
            + "aliquam sagittis <b>gravida eu </b>dolor. Etiam sit amet ipsum "
            + "sem."
            +"<html><body>Lorem ipsum dolor sit "
            + "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
            + "in scelerisque cursus, pulvinar at ante. Nulla consequat"
            + "congue lectus in sodales. Nullam eu est a felis ornare "
            + "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
            + "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
            + "Integer congue faucibus dapibus. Integer id nisl ut elit "
            + "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
            + "sem.</body></html>";
    @Override
    public void start(Stage stage){
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        
        VBox root = new VBox();
        root.setPadding(new Insets(8, 8, 8, 8));
        root.setSpacing(5);
        root.setAlignment(Pos.BOTTOM_LEFT);
        
        
        final HTMLEditor htmlEditor = new HTMLEditor(); 
        htmlEditor.setPrefHeight(300);
        htmlEditor.setHtmlText(initialText);
        htmlEditor.setStyle(
            "-fx-font: 12 cambria;"
            + "-fx-border-color: brown; "
            + "-fx-border-style: dotted;"
            + "-fx-border-width: 2;"
        );
        
        final TextArea htmlCode = new TextArea();
        htmlCode.setWrapText(true);
        
        ScrollPane sp = new ScrollPane();
        sp.getStyleClass().add("noborder-scroll-pane");
        sp.setContent(htmlCode);
        sp.setFitToWidth(true);
        sp.setPrefWidth(200);
        
        Button showBut = new Button("Produce HTML Code");
        root.setAlignment(Pos.CENTER);
        showBut.setOnAction(new EventHandler <ActionEvent> (){
            @Override
            public void handle(ActionEvent arg0){
                htmlCode.setText(htmlEditor.getHtmlText());
                System.out.println(htmlEditor.getHtmlText());
            }
        });
        
        root.getChildren().addAll(htmlEditor, showBut, sp);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}