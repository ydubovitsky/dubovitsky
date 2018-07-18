package Tracker;

public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}