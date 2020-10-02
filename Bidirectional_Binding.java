import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bidirectional_Binding{

    public static void main(String args[]){
        User contact = new User("James","Bond");
        StringProperty fname = new SimpleStringProperty();
        fname.bindBidirectional(contact.firstNameProperty());
        
        contact.firstNameProperty().set("new value");
        fname.set("New First Name");
        
        System.out.println("firstNameProperty=" +contact.firstNameProperty().get());
        System.out.println("fname ="+fname.get());
        
    }
}
    class User{
        private SimpleStringProperty firstName = new SimpleStringProperty();
        private SimpleStringProperty lastName = new SimpleStringProperty();
        
        public User(String fn,String ln){
            firstName.setValue(fn);
            lastName.setValue(ln);
        }
        public final String getFirstName(){
            return firstName.getValue();
        }
        public  StringProperty firstNameProperty(){
            return firstName;
        }
        public final void setFirstName(String firstName){
            this.firstName.setValue(firstName);
        }
        public final String getLastName(){
            return lastName.getValue();
        }
        public StringProperty lastNameProperty(){
            return lastName;
        }
        public final void setLastName(String lastName){
            this.lastName.setValue(lastName);
        }

    }