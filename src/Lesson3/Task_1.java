package Lesson3;

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Ваня",
                "Ваня",
                "Дима",
                "Петя",
                "Саша",
                "Сережа",
                "Костя",
                "Настя",
                "Ваня",
                "Света",
                "Ира",
                "Петя",
                "Марина",
                "Ваня",
                "Лера",
                "Витя",
                "Антон",
                "Миша",
                "Лиза",
                "Ира"
);

        System.out.println("Всего записей: " + words.size());


        //Чтобы оставить в массиве только уникальные значения я решил создать из всех слов Set
        Set<String> wordsSet = new LinkedHashSet<>(words);
        System.out.println("Уникальных записей: " + wordsSet.size());

        //И потом преобразовать обратно в List что бы иметь доступ к элементу по индексу
        List<String> uniqWords = new ArrayList<>(wordsSet);

        // В цикле я проверяю сколько раз содержится уникальное значение из массива uniqWords в массиве words
        for (int i = 0; i < uniqWords.size(); i++){
            int count = 0;
            for (int j = 0; j < words.size(); j++){
                if (uniqWords.get(i).equals(words.get(j))){
                    count++;
                }
            }
            System.out.println(uniqWords.get(i) + ": " + count + " раз");
        }






    }
}

