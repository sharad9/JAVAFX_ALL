import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.control.TextArea;
public class Pagination1 extends Application{
  private Pagination pagination;  
  String fonts[] = new String[]{};// Dinamic Array-->{data}
    public static void main(String[] args) throws Exception {
    launch(args);
  }
  public int itemsPerPage(){
      return 8;
    }  
    
  public VBox createPage(int pageIndex){
      VBox box = new VBox(5);
      int page = pageIndex*itemsPerPage();
      for (int i = page; i<page+itemsPerPage(); i++){
          VBox element = new VBox();
          Hyperlink link= new Hyperlink ("Item" +(i+1));
          link.setVisited(true);
          //Label text = new Label(fonts[i]+"__"+link.getText());
          //text.setText(fonts[i]+link.getText());
          TextArea text = new TextArea(fonts[i]+"__"+link.getText());
          text.setWrapText(true);
          element.getChildren().addAll(link,text);
          box.getChildren().add(element);
        }
        
        return box;
    }  
    
    @Override
    public void start(final Stage stage) throws Exception{
        fonts = Font.getFamilies().toArray(fonts);
        pagination = new Pagination(fonts.length/itemsPerPage(),0);//Max,start pos
        pagination.setStyle("-fx-border-color:red;");
        pagination.setPageFactory(new Callback<Integer, Node>(){
            @Override 
            public Node call (Integer pageIndex){
                return createPage(pageIndex);
                
            } 
        });
        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination,10.0);
        AnchorPane.setRightAnchor(pagination,10.0);
        AnchorPane.setBottomAnchor(pagination,10.0);
        AnchorPane.setLeftAnchor(pagination,10.0);
        
        anchor.getChildren().addAll(pagination);
        Scene scene = new Scene(anchor,500,300);
        stage.setTitle("sample");
        stage.setScene(scene);
        stage.show();
        
    }
}