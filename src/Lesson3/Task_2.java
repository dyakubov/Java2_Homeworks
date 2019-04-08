package Lesson3;


import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "172-31-25");
        phonebook.add("Иванов", "434-44-34");
        phonebook.add("Петров", "888-88-00");

        System.out.println(phonebook.get("Иванов"));
        System.out.println(phonebook.get("Петров"));


    }
}





