import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DatePicker3 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
      VBox vbox = new VBox(20);
    Scene scene = new Scene(vbox, 400, 400);
    stage.setScene(scene);
    
    DatePicker startDatePicker = new DatePicker();
    DatePicker endDatePicker = new DatePicker();
    
    startDatePicker.setValue(LocalDate.now());
    final Callback<DatePicker , DateCell> dayCellFactory = new Callback<DatePicker, DateCell>(){
        @Override
        public DateCell call (final DatePicker datePicker){
            return new DateCell(){
                @Override
                public void updateItem(LocalDate item, boolean empty){
                    super.updateItem(item, empty);
                    
                    if(item.isBefore(startDatePicker.getValue().plusDays(1))){
                        setDisable(true);
                        setStyle("-fxbackground-color:#EEEEEE");
                    }
                    
                    long p = ChronoUnit.DAYS.between(startDatePicker.getValue(),item);
                    setTooltip(new Tooltip("You are about to stay for "+p+" days"));
                    
                }
            };
        }
        
            
        
    };
    
    endDatePicker.setDayCellFactory(dayCellFactory);
    endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
    vbox.getChildren().add(new Label("Start Date:"));
    vbox.getChildren().add(startDatePicker);
    vbox.getChildren().add(new Label("End Date:"));
    vbox.getChildren().add(endDatePicker);
    stage.show();
    
    }
}