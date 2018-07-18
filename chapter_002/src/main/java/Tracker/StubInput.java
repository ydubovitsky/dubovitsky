package Tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        System.out.println(question + " " + value[position]);
        return value[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return 0;
    }
}
