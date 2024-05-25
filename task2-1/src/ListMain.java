import java.util.ArrayList;

public class ListMain {

    public java.util.List<Integer> ascendingSortOrder(java.util.List<Integer> list) {
        int buf;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    buf = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, buf);
                }
            }
        }
        return list;
    }

    public java.util.List<Integer> descendingSortOrder(java.util.List<Integer> list) {
        int buf;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j + 1) > list.get(j)) {
                    buf = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, buf);
                }
            }
        }

        return list;
    }

    public java.util.List<Integer> positive(java.util.List<Integer> list) {
        java.util.List<Integer> positiveList = new ArrayList<>();

        for (Integer integer : list){
            if (integer > 0) {
                positiveList.add(integer);
            }
        }

        return positiveList;
    }

    public java.util.List<Integer> negative(java.util.List<Integer> list) {
        java.util.List<Integer> positiveList = new ArrayList<>();

        for (Integer integer : list){
            if (integer < 0) {
                positiveList.add(integer);
            }
        }
        return positiveList;
    }

    public java.util.List<Integer> even (java.util.List<Integer> list) {
        java.util.List<Integer> positiveList = new ArrayList<>();

        for (Integer integer : list){
            if (integer%2 == 0) {
                positiveList.add(integer);
            }
        }
        return positiveList;
    }

    public java.util.List<Integer> odd (java.util.List<Integer> list) {
        java.util.List<Integer> positiveList = new ArrayList<>();

        for (Integer integer : list){
            if (integer%2 != 0) {
                positiveList.add(integer);
            }
        }
        return positiveList;
    }

    public java.util.List<Integer> positiveEvenAscending(java.util.List<Integer> list) {
        java.util.List<Integer> integerList = new ArrayList<>();
        integerList = ascendingSortOrder(positive(even(list)));

        return integerList;
    }
}
