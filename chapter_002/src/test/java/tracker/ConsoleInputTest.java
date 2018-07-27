package tracker;

import org.junit.Test;

public class ConsoleInputTest {
    @Test
    public void whenUserInsertDataFromConsole() {
        Tracker tracker = new Tracker();
        ConsoleInput consoleInput = new ConsoleInput();
        StartUI startUI = new StartUI(consoleInput);
        startUI.init();
    }
}
