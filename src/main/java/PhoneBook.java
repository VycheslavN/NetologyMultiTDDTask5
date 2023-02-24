import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
   Map<Integer, String> contacts = new HashMap<>();

   void add() {
        for (Map.Entry<Integer, String> item : contacts.entrySet()) {
            System.out.println("номер телефона: " + item.getKey() + "имя контакта: " + item.getValue());
            return;
        }
    }
}


