import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTableColumns extends Application{
    List<Employee> employees = Arrays.<Employee> asList(new Employee("Sharad Maddhieshiya","sharadrakeshm@gmail.com"),
            new Employee( "Emma Jones", "emma.jones@example.com"), new Employee("Michael Brown",
                "michael.brown@example.com"), new Employee("Anna Black",
                "anna.black@example.com"), new Employee("Rodger York",
                "roger.york@example.com"), new Employee("Susan Collins",
                "susan.collins@example.com"));

    final TreeItem<Employee> root = new TreeItem<>(new Employee(
                "Sales Department", ""));
    
    @Override
    public void start(Stage stage){
        root.setExpanded(true);
        employees.stream().forEach((employee) -> {
      root.getChildren().add(new TreeItem<>(employee));
    });
    
    Scene scene = new Scene(new Group(),400,400);
    Group sceneRoot = (Group) scene.getRoot();
    
    TreeTableColumn <Employee,String> empColumn = new TreeTableColumn<>("Employee");
    empColumn.setPrefWidth(150);
    empColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee,String> param)-> new ReadOnlyStringWrapper(param.getValue().getValue().getName()));
    
    TreeTableColumn<Employee,String> emailColumn = new TreeTableColumn<>("Email");
    emailColumn.setPrefWidth(150);
    emailColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee,String> param)-> new ReadOnlyStringWrapper(param.getValue().getValue().getEmail()));
    
    TreeTableView<Employee> treeTableView = new TreeTableView<>(root);
    treeTableView.getColumns().setAll(empColumn,emailColumn);
    treeTableView.setTableMenuButtonVisible(true);
    sceneRoot.getChildren().add(treeTableView);
    stage.setScene(scene);
    stage.show();
    }
    public static void main(String[] args) {
        Application.launch(TreeTableColumns.class, args);
    }

    public class Employee{
        private SimpleStringProperty name;
        private SimpleStringProperty email;

        public SimpleStringProperty nameProperty(){
            if(name == null){
                name = new SimpleStringProperty(this,"name");
            }
            return name;
        }

        public SimpleStringProperty emailProperty(){
            if(email == null){
                email = new SimpleStringProperty(this,"email");
            }
            return email;
        }

        private Employee (String name, String email){
            this.name = new SimpleStringProperty(name);
            this.email = new SimpleStringProperty(email);

        }

        public String getName(){
            return name.get();
        }

        public void setName(String fName){
            name.set(fName);
        }

        public String getEmail(){
            return email.get();
        }

        public void setEmail(String fEmail){
            email.set(fEmail);
        }

    }
}
