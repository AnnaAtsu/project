package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Hello world!
 *
 */
public class App {
    //1. Найти первое неповторяющееся число в массиве.
   // Пример: {4, 5, 1, 2, 1, 4, 2} → результат: 5

          //  2. Проверить, является ли строка палиндромом.
   // Пример: "level" → true

     //       3. Посчитать количество гласных букв в строке.
  //  Пример: "Автотестирование" → 7

   //         4. Развернуть строку без использования StringBuilder.reverse().
   // Пример: "Selenium" → "muineleS"

   //         5. Посчитать сумму всех чисел в списке с помощью Stream API.
   // Пример: [1, 2, 3, 4, 5] → 15



     //       7. Найти самое длинное слово в списке строк.
      //      Пример: ["Selenium", "Java", "Automation", "Test"] → "Automation"



     //       9. Найти топ-1 самый часто встречающийся элемент в списке.
  //  Пример: ["Москва", "Казань", "Москва", "Томск", "Москва", "Казань"] → "Москва



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

        //     8. Удалить дубликаты из списка (Stream API + distinct).
        /// Пример: [1, 2, 2, 3, 4, 4, 5] → [1, 2, 3, 4, 5]

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> nonDubl = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nonDubl);
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

        //         5. Посчитать сумму всех чисел в списке с помощью Stream API.
        // Пример: [1, 2, 3, 4, 5] → 15

        List<Integer> summa = Arrays.asList(1, 2, 3, 4, 5);

        Integer mysumma = summa.stream()
                .reduce(0, Integer::sum);

        System.out.println(mysumma);
    }


}
