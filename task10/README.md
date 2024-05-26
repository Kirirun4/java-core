/*Вначале JVM с помощью ClassLoader загрузит классы. С помощью Application ClassLoader загрузит класс JvmComprehension. 
С помощью Bootstrap ClassLoader загрузит классы System, Object и другие системные. 
Создаётся стековая память(Stack Memory).*/

public class JvmComprehension {

    public static void main(String[] args) { /*создаст фрейм  main в Stack Memory*/
        int i = 1;                      // 1 /*создаст переменую в Stack Memory*/
        Object o = new Object();        // 2 /*создаст в heap объект "o"*/
        Integer ii = 2;                 // 3 /*создаст в heap объект "ii"*/
        printAll(o, i, ii);             // 4 /*создаст фрейм  printAll в Stack Memory*/
        System.out.println("finished"); // 7 /*создаст фрейм  toString в Stack Memory*/
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 /*создаст в heap объект "uselessVar"*/
        System.out.println(o.toString() + i + ii);  // 6 /*создаст фрейм  toString в Stack Memory*/
    }
}

/*Сборщик мусора почистит объекты которые становятся недостижимыми при дальнейшем исполнении программы.*/