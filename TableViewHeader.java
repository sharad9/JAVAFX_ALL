import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class TableViewHeader extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Fisrt Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(firstNameCol,lastNameCol,emailCol);
        //emailCol.setVisible(true);
        TableColumn cityCol = new TableColumn("City");
        TableColumn stateCol = new TableColumn("State");
        emailCol.getColumns().addAll(cityCol, stateCol);


        StackPane root = new StackPane();
        root.getChildren().add(table);
        stage.setScene(new Scene(root,400,300));
        stage.show();

    }
}