import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DragDropListPENDING extends Application {
    String s [] = new String [] {};
  private static ListView<Student> leftListView ;

  private static final ObservableList<Student> leftList = FXCollections
      .observableArrayList();
  private static final ObservableList<Student> rightList = FXCollections
      .observableArrayList();
  private static  ListView<Student> rightListView;

  private static final GridPane rootPane = new GridPane();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    initializeComponents();
    initializeListeners();

    buildGUI();

    populateData();

    primaryStage.setScene(new Scene(rootPane, 400, 325));
    primaryStage.show();
  }

  private void initializeListeners() {
    // drag from left to right
    leftListView.setOnDragDetected(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        if (leftListView.getSelectionModel().getSelectedItem() == null) {
          return;
        }

        Dragboard dragBoard = leftListView.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(leftListView.getSelectionModel().getSelectedItem()
            .getName());
        dragBoard.setContent(content);
      }
    });

    rightListView.setOnDragOver(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.MOVE);
      }
    });

    rightListView.setOnDragDropped(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent dragEvent) {
        String player = dragEvent.getDragboard().getString();
        leftList.remove(new Student(player));
       

        rightList.add(new Student(player));
       
        
        dragEvent.setDropCompleted(true);
      }
    });
    // drag from right to left
    rightListView.setOnDragDetected(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        Dragboard dragBoard = rightListView.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(rightListView.getSelectionModel().getSelectedItem()
            .getName());
        dragBoard.setContent(content);
      }
    });

    leftListView.setOnDragOver(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.MOVE);
      }
    });

    leftListView.setOnDragDropped(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent dragEvent) {
        String player = dragEvent.getDragboard().getString();
         rightList.remove(new Student(player));
     

        leftList.add(new Student(player));
    
        
        dragEvent.setDropCompleted(true);
      }
    });
  }

  private void buildGUI() {
    rootPane.setPadding(new Insets(10));
    rootPane.setPrefHeight(30);
    rootPane.setPrefWidth(100);
    rootPane.setVgap(10);
    rootPane.setHgap(20);

    Label playersLabel = new Label("Players");
    Label teamLabel = new Label("Team");

    rootPane.add(playersLabel, 0, 0);
    rootPane.add(leftListView, 0, 1);
    rootPane.add(teamLabel, 1, 0);
    rootPane.add(rightListView, 1, 1);
  }

  private void populateData() {
    leftList.addAll(new Student("Adam"), new Student("Alex"), new Student(
        "Alfred"));

    leftListView.setItems(leftList);
    rightListView.setItems(rightList);
  }

  private void initializeComponents() {
    leftListView=initializeListView(leftListView);

    rightListView=initializeListView(rightListView);
  }

  private ListView<Student> initializeListView(ListView<Student> listView) {
    listView = new ListView<Student>(); 
    listView.setPrefSize(250, 290);
    listView.setEditable(false);
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    listView.setCellFactory(new StringListCellFactory());
    
    return listView;
  }

  class StringListCellFactory implements
      Callback<ListView<Student>, ListCell<Student>> {
    @Override
    public ListCell<Student> call(ListView<Student> playerListView) {
      return new StringListCell();
    }

    class StringListCell extends ListCell<Student> {
      @Override
      protected void updateItem(Student player, boolean b) {
        super.updateItem(player, b);

        if (player != null) {
          setText(player.getName());
        }
      }
    }
  }
}

class Student {
  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Student player = (Student) o;

    if (name != null ? !name.equals(player.name) : player.name != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}