import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class High_level_Binding{
    public static void main(String args[]){
        IntegerProperty width = new SimpleIntegerProperty(10);
        IntegerProperty height = new SimpleIntegerProperty(10);
        NumberBinding area = width.multiply(height).divide(2).multiply(2).divide(1);
        // subtract(0), isEqualTo(), isNotEqualTo(), concat();
        System.out.println(area.getValue());
    }
}