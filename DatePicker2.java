import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class DatePicker2 extends Application{
    public static void main(String args []){
        launch(args);
    }
    @Override
    public void start(Stage stage){
    
        String pattern = "yyyy-MM-dd";
        VBox vbox = new VBox(20);
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        
        DatePicker checkInDatePicker = new DatePicker();
        StringConverter <LocalDate> converter = new StringConverter<LocalDate>(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
        
        @Override 
        public String toString(LocalDate date){
            if(date != null){
                return dateFormatter.format(date);
            }else{
                return "";
            }
        }
        
        @Override
        public LocalDate fromString(String string){
            if(string != null && !string.isEmpty()){
                return LocalDate.parse(string, dateFormatter);
                
            }else{
                return null;
            }
        }
        };
        checkInDatePicker.setConverter(converter);
        checkInDatePicker.setPromptText(pattern.toLowerCase());
        
        vbox.getChildren().add(checkInDatePicker);
        checkInDatePicker.requestFocus();
        stage.show();
    }
}