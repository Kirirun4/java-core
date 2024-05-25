import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public List<Integer> positiveEvenAscending(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();

        integerList = list.stream()
                .filter(integer -> integer > 0)
                .filter(integer -> integer%2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return integerList;
    }
}
