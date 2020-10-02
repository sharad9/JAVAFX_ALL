import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.control.TextField;
public class MenuItems extends Application{
    @Override 
    public void start(Stage stage){
        VBox vb = new VBox();
        BorderPane root = new BorderPane();
        vb.getChildren().add(root);
        Scene scene = new Scene(vb, 300, 300, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);

        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        exitMenuItem.setMnemonicParsing(true);
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.SHORTCUT_DOWN));

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
            new SeparatorMenuItem(), exitMenuItem);
            
        Menu webMenu = new Menu("Web");
        CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
        htmlMenuItem.setSelected(true);
        CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
        cssMenuItem.setSelected(true);
        
        webMenu.getItems().addAll(htmlMenuItem,cssMenuItem);
        
        Menu sqlMenu = new Menu("SQL");
        ToggleGroup tGroup = new ToggleGroup();
        
        RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
        mysqlItem.setToggleGroup(tGroup);
        mysqlItem.setSelected(true);
        
        RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
        oracleItem.setToggleGroup(tGroup);
        oracleItem.setSelected(true);
        
        Menu tutorialMenu = new Menu("Tutorial");
        tutorialMenu.getItems().addAll(new CheckMenuItem("Java"),
                                       new CheckMenuItem("JavaFx"),
                                       new CheckMenuItem("Swing"));
                                       
       CustomMenuItem customMenuItem = new  CustomMenuItem(new Slider());
       customMenuItem.setHideOnClick(false);
                                       
        
       sqlMenu.getItems().addAll(mysqlItem, oracleItem, new SeparatorMenuItem(),tutorialMenu,customMenuItem);
       
        
       TextField tf = new TextField();
       tf.setMaxWidth(80);
       //tf.setPrefWidth(800);
       tf.setPrefHeight(100);
       ContextMenu contextFileMenu = new ContextMenu(mysqlItem); 
       tf.setContextMenu(contextFileMenu);
       vb.getChildren().addAll(tf);
       //hb.setCenter(tf);
       menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
       
        
       tf.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent me)->{
        if(me.getButton() == MouseButton.SECONDARY || me.isControlDown()){
            System.out.println("ppp");
            contextFileMenu.show(tf, me.getScreenX(), me.getScreenY());
        }else{
            contextFileMenu.hide();
        }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}