package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTrackerTest {

    MenuTracker menuTracker;
    Input input;
    Tracker tracker;
    UserAction[] actions = new UserAction[6];

    @Before
    public void init() {
        input = new ConsoleInput();
        tracker = new Tracker();
        menuTracker = new MenuTracker(input, tracker);
    }


    @After


    @Test
    public void fillActions() {
        
    }

    @Test
    public void doAction() {
    }

    @Test
    public void show() {
    }
}