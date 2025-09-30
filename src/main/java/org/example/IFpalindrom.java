package org.example;


public class IFpalindrom {
    ///2. Проверить, является ли строка палиндромом.
    // Пример: "level" → true
    public static boolean ifpali() {
        String str="шалаш";
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}


//public static void ifpalindrom(String[] args)
//{
  //  System.out.println(ifpali());
//}
