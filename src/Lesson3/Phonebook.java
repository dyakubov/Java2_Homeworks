package Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, List<String>> phonebook = new HashMap<>();


    public void add (String name, String number){
        if (phonebook.containsKey(name)){
            phonebook.get(name).add(number);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(number);
            phonebook.put(name, temp);
        }

    }

    public List<String> get (String name){
        return phonebook.get(name);
    }
}
