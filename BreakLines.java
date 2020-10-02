import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.effect.InnerShadow;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class BreakLines extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("BreakLines");
        Group root = new Group();
        Scene scene = new Scene(root,530,300,Color.WHITE);
        
        InnerShadow is = new InnerShadow();
        is.setOffsetX(3.5f);
        is.setOffsetY(3.5f);
        is.setColor(Color.color(0,0.5,0.9));
        
        final StringProperty statusProperty = new SimpleStringProperty();
        Text t = new Text(34,50,"This is test");
        t.setX(10.0);
        t.setY(50.0);
        t.setCache(true);
        //t.setText("Ni\n Bufer\n Tu \n Meraa");
        t.setWrappingWidth(200);
        t.setText("First row Second row Second row Second row Second row Second row");
        t.setFill(Color.RED);
        t.setFont(Font.font(null,FontWeight.BOLD,20));
        t.setEffect(is);
        //t.textProperty().bind(statusProperty);
        root.getChildren().add(t);
        stage.setScene(scene);
        stage.show();
        
        
    }
}