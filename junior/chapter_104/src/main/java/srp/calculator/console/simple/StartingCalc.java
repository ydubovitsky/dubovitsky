package srp.calculator.console.simple;

/**
 * This is a basis class, which starting all application
 */
public class StartingCalc {
    public static void main(String[] args) {
        UserInput userInput = new UserInput(System.in);
        StringParsing stringParsing = new StringParsing(System.out);
        stringParsing.fillMapFunctions();
        userInput.registerObserver(stringParsing);
        Thread thread = new Thread(userInput);
        thread.start();
    }
}
