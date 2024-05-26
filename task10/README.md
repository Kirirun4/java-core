# Задача "Понимание JVM"

## Описание
Просмотрите код ниже и опишите (текстово или с картинками) каждую строку с точки зрения происходящего в JVM  

Не забудьте упомянуть про: 
- ClassLoader'ы, 
- области памяти (стэк (и его фреймы), хип, метаспейс)  
- сборщик мусора

## Код для исследования

```java
public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1
        Object o = new Object();        // 2
        Integer ii = 2;                 // 3
        printAll(o, i, ii);             // 4
        System.out.println("finished"); // 7
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5
        System.out.println(o.toString() + i + ii);  // 6
    }
}
```
## Решение

*Вначале JVM с помощью ClassLoader загрузит классы. 
С помощью Application ClassLoader загрузит класс JvmComprehension. 
С помощью Bootstrap ClassLoader загрузит классы System, Object и другие системные. 
Создаётся стековая память(Stack Memory).*

```java
public class JvmComprehension {

    public static void main(String[] args) { /*создаст фрейм  main в Stack Memory*/
        int i = 1;                      // 1 /*создаст переменую i в Stack Memory* со значением 1/
        Object o = new Object();        // 2 /*создаст в heap объект "o",
						которому присваивается ссылка на этот объект*/
        Integer ii = 2;                 // 3 /*создаст в heap объект Integer "ii" со значением 2*/
        printAll(o, i, ii);             // 4 /*создаст фрейм  printAll в Stack Memory,
						в нем записываются переменные Object o, int i и Integer ii*/
        System.out.println("finished"); // 7 /*создаст фрейм  println в Stack Memory,
						которому передается ссылка на объект String со значением "finished"*/
		/*в ходе работы программы отрабатывает Garbage Collector*/
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 /*создаст в heap Integer объект "uselessVar"
							со значением 700, а во фрейме printAll появляется
							переменная uselessVar со ссылкой на этот объект*/
        System.out.println(o.toString() + i + ii);  // 6 /*создаст фреймы println и toString в
							Stack Memory, на фрейм println передаются
							ссылки на Object o, int i и Integer ii*/
    }
}
```

*Сборщик мусора почистит объекты которые становятся недостижимыми при дальнейшем исполнении программы.*
