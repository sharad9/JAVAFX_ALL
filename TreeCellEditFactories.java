import java.util.Arrays;
import java.util.List;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class TreeCellEditFactories extends Application{
    List<Employee> employees = Arrays.<Employee> asList(new Employee("Sharad","Business"),new Employee(
                "Jacob Smith", "Accounts Department"), new Employee("Isabella Johnson",
                "Accounts Department"), new Employee("Mike Graham", "IT Support"),
            new Employee("Judy Mayer", "IT Support"), new Employee("Gregory Smith",
                "IT Support"));
    TreeItem<String> rootNode;
    public static void main(String[] args) {
        Application.launch(args);
    }

    public TreeCellEditFactories(){
        this.rootNode = new TreeItem<>("My Company employees");

    }

    @Override
    public void start(Stage stage){
        rootNode.setExpanded(true);
        for(Employee employee : employees){
            TreeItem<String> empLeaf = new TreeItem<>(employee.getName());
            boolean found = false;
            for(TreeItem<String> depNode: rootNode.getChildren()){
                if(depNode.getValue().contentEquals(employee.getDepartment())){
                    depNode.getChildren().add(empLeaf);
                    found= true;
                    break;
                }
            }
            if(!found){
                TreeItem<String>depNode = new TreeItem<>(employee.getDepartment());
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }
        stage.setTitle("__________________");
        VBox box = new VBox();
        final Scene scene = new Scene(box, 500,400);
        scene.setFill(Color.LIGHTGRAY);

        TreeView <String> treeView = new TreeView<>(rootNode);
        treeView.setEditable(true);
        treeView
        .setCellFactory((TreeView<String> p) -> new TextFieldTreeCellImpl());

        box.getChildren().add(treeView);
        stage.setScene(scene);
        stage.show();

    }
    private final class TextFieldTreeCellImpl extends TreeCell<String>{
        private TextField textField;
        private final ContextMenu addMenu = new ContextMenu();
        public TextFieldTreeCellImpl(){
            MenuItem addMenuItem = new MenuItem("Add Employee");
            addMenu.getItems().add(addMenuItem);
            addMenuItem.setOnAction((ActionEvent t)->{
                    TreeItem newEmployee = new TreeItem<>("New Employee");
                    getTreeItem().getChildren().add(newEmployee);
                });

        }

        @Override
        public void startEdit(){
            super.startEdit();

            if(textField == null){
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit(){
            super.cancelEdit();
            setText((String)getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item,boolean empty){
            super.updateItem(item,empty);

            if(empty){
                setText(null);
                setGraphic(null);
            }else{
                if(isEditing()){
                    if(textField != null){
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                }else{
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                    if(!getTreeItem().isLeaf()&&getTreeItem().getParent()!=null)

                        setContextMenu(addMenu);

                }
            }
        }

        private void createTextField(){
            textField = new TextField(getString());
            textField.setOnKeyReleased((KeyEvent t)->{
                    if(t.getCode() == KeyCode.ENTER){
                        commitEdit(textField.getText());

                    }else if(t.getCode() == KeyCode.ESCAPE){
                        cancelEdit();
                    }
                });

        }

        private String  getString(){
            return getItem() == null ? "" : getItem().toString();
        }
    } 
    public static class Employee {

        private final SimpleStringProperty name;
        private final SimpleStringProperty department;

        private Employee(String name, String department) {
            this.name = new SimpleStringProperty(name);
            this.department = new SimpleStringProperty(department);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getDepartment() {
            return department.get();
        }

        public void setDepartment(String fName) {
            department.set(fName);
        }
    }   
}