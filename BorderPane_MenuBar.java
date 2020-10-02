import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BorderPane_MenuBar extends Application{
     public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Title");
        Group root = new Group();
        Scene scene = new Scene(root,400,300,Color.WHITE);
        
        MenuBar menuBar = new MenuBar();
        EventHandler<ActionEvent> action = changeTabPlacement();
        
        Menu menu = new Menu("Direction");
        
        MenuItem left = new MenuItem("Left");
        left.setOnAction(action);
        menu.getItems().add(left);

        MenuItem right = new MenuItem("Right");
        right.setOnAction(action);
        menu.getItems().add(right);

        MenuItem top = new MenuItem("Top");
        top.setOnAction(action);
        menu.getItems().add(top);

        MenuItem bottom = new MenuItem("Bottom");
        bottom.setOnAction(action);
        menu.getItems().add(bottom);
        
        menuBar.getMenus().add(menu);
        
        BorderPane borderPane = new BorderPane();
        
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setTop(menuBar);
        root.getChildren().add(borderPane);
        
        stage.setScene(scene);
        stage.show();
        

    } 
    
    private EventHandler<ActionEvent> changeTabPlacement(){
        return new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                if("left".equalsIgnoreCase(side)){
                    System.out.println("left");
                }else
                if("right".equalsIgnoreCase(side)){
                    System.out.println("right");
                }else
                if("top".equalsIgnoreCase(side)){
                    System.out.println("top");
                }else
                if("bottom".equalsIgnoreCase(side)){
                    System.out.println("bottom");
                }
                
            }
        
        };
    }
}