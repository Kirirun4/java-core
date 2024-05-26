public class StringUtils {
    public StringUtils() { }

    public static String joinArray(String[] source, char del) {
        if (source == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length - 1; i++) {
            result.append(source[i]);
            result.append(del);
        }

        result.append(source[source.length - 1]);

        return result.toString();
    }

    public static String[] toArray(String source, char delimiter) {
        if (source == null) {
            return new String[]{};
        }
        return source.split(Character.toString(delimiter));
    }

    public static boolean isEmpty(final String subject) {
        return subject == null || subject.replaceAll("\\s", "").isEmpty();
    }

    public static double toDouble(String source) {
        if (source == null) {
            return Double.NaN;
        }
        return Double.parseDouble(source);
    }

    public static String fromDouble(double source) {
        return String.valueOf(source);
    }
}
