import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    Map<String, String> contacts = new TreeMap<>();

    public int add(String name, String number) { //add — добавить имя с номером
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
        }
        return contacts.size();
    }

    public String findByNumber(String number) { //findByNumber — найти имя по номеру без полного перебора
        return contacts.entrySet().stream().filter((x) -> x.getValue().equals(number)).map(Map.Entry::getKey).findFirst().get();
    }

    public String findByName(String name) { //findByName — найти номер по имени без полного перебора
        return contacts.get(name);
    }


    public List<String> printAllNames() { //printAllNames — вывести все имена в алфавитном порядке
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }
}