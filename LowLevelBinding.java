import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
//www  . j ava2 s .  c  om
public class LowLevelBinding {
  public static void main(String[] args) {
    DoubleProperty width = new SimpleDoubleProperty(2);
    DoubleProperty height = new SimpleDoubleProperty(2);
    DoubleBinding area = new DoubleBinding() {
      {
        super.bind(width, height); // initial bind
      }

      @Override
      protected double computeValue() {
        return width.get() * height.get();
      }
    };
    System.out.println(area.get());
  }
}