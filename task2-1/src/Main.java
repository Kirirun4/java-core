import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListMain ListMain = new ListMain();
        StreamMain StreamMain = new StreamMain();

        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> list1 = ListMain.positiveEvenAscending(list);
        System.out.println(list1.toString());

        List<Integer> list2 = StreamMain.positiveEvenAscending(list);
        System.out.println(list2.toString());
    }
}