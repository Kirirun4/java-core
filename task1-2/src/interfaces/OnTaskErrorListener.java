package interfaces;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}
