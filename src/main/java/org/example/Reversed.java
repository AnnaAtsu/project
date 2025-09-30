package org.example;

public class Reversed {

    //         4. Развернуть строку без использования StringBuilder.reverse().
    // Пример: "Selenium" → "muineleS"
   public static String getReversed(String frase2) {
        String reversed = "";
       for (int i = frase2.length() - 1; i >= 0; i--) {
           reversed += frase2.charAt(i);
       }
       return reversed;
   }

}
