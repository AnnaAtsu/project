package org.example;



public class Allvowels {



    public static void onlyvowels() {
        //       3. Посчитать количество гласных букв в строке.
        //  Пример: "Автотестирование" → 7
        String word= "автотестирование";
        char[]letters = word.toCharArray();
         for(char c: letters) {
             System.out.println(c);
        }
}

}
