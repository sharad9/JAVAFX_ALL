import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTable1 extends Application{

    public static void main(String args []){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
        final Scene scene = new Scene(new Group(), 200, 400);
        Group sceneRoot = (Group) scene.getRoot();
        
        TreeItem<String> childNode1 = new TreeItem<>("Node 1");
        TreeItem<String> childNode2 = new TreeItem<>("Node 2");
        TreeItem<String> childNode3 = new TreeItem<>("Node 3");
        
        TreeItem<String> root = new TreeItem<>("Root");
        root.setExpanded(true);
        
        root.getChildren().setAll(childNode1,childNode2,childNode3);
        
        TreeTableColumn<String ,String> column = new TreeTableColumn<>("Column");
        column.setPrefWidth(150);
        
        column.setCellValueFactory((CellDataFeatures<String,String>p) -> new ReadOnlyStringWrapper(p.getValue().getValue()));
        TreeTableView <String> treeTableView = new TreeTableView<>(root);
        
        treeTableView.getColumns().add(column);
        sceneRoot.getChildren().add(treeTableView);
        stage.setScene(scene);
        stage.show();
        
    }
}