package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Hello world!
 *
 */
public class App {




    record Person(String name, int salary) {}

    record Names(String name1, int age) {}
    public static void main(String[] args) {



        //10.Отсортировать список сотрудников по зарплате (Stream API + sorted).
        //  // Пример: [Анна(1000), Борис(2000), Марина(1500)] → [Анна, Марина, Борис
        List<Person> people = Arrays.asList(
                new Person("Анна", 1000),
                new Person("Борис", 2000),
                new Person("Марина", 1500)
        );


        List<Person> price = people.stream()
                .sorted(Comparator.comparingInt(Person::salary).reversed())
                //reversed считает от большего к меньшему
                .collect(Collectors.toList());
        System.out.println(price);
        System.out.println("--------------");

        //     8. Удалить дубликаты из списка (Stream API + distinct).
        /// Пример: [1, 2, 2, 3, 4, 4, 5] → [1, 2, 3, 4, 5]

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> nonDubl = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nonDubl);
        System.out.println("--------------");
        //   6. Получить список имён всех людей старше 25 лет (Stream API + filter + map).
        //  Пример: [Анна(21), Борис(30), Марина(27)] → ["Борис", "Марина"]


        List<Names> Names = Arrays.asList(
                new Names ("Анна", 21),
                new Names ("Борис", 30),
                new Names ("Марина", 27),
                new Names ("Юля", 25));

        List<String> oldage = Names.stream()
                                .filter(p -> p.age() > 25)
                         .map(App.Names::name1)
                        .collect(Collectors.toList());
        System.out.println(oldage);
        System.out.println("--------------");

        //         5. Посчитать сумму всех чисел в списке с помощью Stream API.
        // Пример: [1, 2, 3, 4, 5] → 15

        List<Integer> summa = Arrays.asList(1, 2, 3, 4, 5);

        Integer mysumma = summa.stream()
                .reduce(0, Integer::sum);

        System.out.println(mysumma);
        System.out.println("--------------");

        //       9. Найти топ-1 самый часто встречающийся элемент в списке.
        //  Пример: ["Москва", "Казань", "Москва", "Томск", "Москва", "Казань"] → "Москва

        List<String> cities = Arrays.asList("Москва", "Казань", "Москва", "Томск", "Москва", "Казань");

        // Шаг 1: Считаем частоту каждого элемента
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String city : cities) {
            frequencyMap.put(city, frequencyMap.getOrDefault(city, 0) + 1);
        }

        // Шаг 2: Находим элемент с максимальной частотой
        String mostFrequent = null;
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println(mostFrequent);

        System.out.println("--------------");


        //       7. Найти самое длинное слово в списке строк.
        //      Пример: ["Selenium", "Java", "Automation", "Test"] → "Automation"
        List<String> words = Arrays.asList("Selenium", "Java", "Automation", "Test");
        String longword = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longword);
        System.out.println("--------------");


        //         4. Развернуть строку без использования StringBuilder.reverse().
        // Пример: "Selenium" → "muineleS"

        String frase = "марафон";
        StringBuilder pali = new StringBuilder(frase);
        pali.reverse();
        System.out.println(pali);
        System.out.println("--------------");



        //1. Найти первое неповторяющееся число в массиве.
        // Пример: {4, 5, 1, 2, 1, 4, 2} → результат: 5

        int[] arr = new int[]{4, 5, 1, 2, 1, 4, 2};
        int result = 0;
        for (int i = 0; i >= 0; i ++) {
            result += arr[i];



        }

     

    }


}
