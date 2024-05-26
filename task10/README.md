--1 Вначале JVM с помощью ClassLoader загрузит классы. С помощью Application ClassLoader загрузит класс JvmComprehension. 
С помощью Bootstrap ClassLoader загрузит классы System, Object и другие системные. 
Создаётся стековая память(Stack Memory) .

public class JvmComprehension {

public static void main(String[] args) { --2 создаст фрейм  main в Stack Memory
    int i = 1;                      // 1 --3 создаст переменую в Stack Memory
    Object o = new Object();        // 2 --4 создаст в heap объект "o"
    Integer ii = 2;                 // 3 --5 создаст в heap объект "ii"
    printAll(o, i, ii);             // 4 --6 создаст фрейм  printAll в Stack Memory
    System.out.println("finished"); // 7 --8 создаст фрейм  toString в Stack Memory
}

--9 Сборщик мусора почистит объекты которые становятся недостижимыми при дальнейшем исполнении программы.

private static void printAll(Object o, int i, Integer ii) {
    Integer uselessVar = 700;                   // 5 --7 создаст в heap объект "uselessVar"
    System.out.println(o.toString() + i + ii);  // 6 --8 создаст фрейм  toString в Stack Memory
}

}
