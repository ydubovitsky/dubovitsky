package srp.calculator.console.simple;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * User input
 */
class UserInput {

    private InputStream input;

    /**
     * stack with user_s strings;
     */
    private Stack<String> stack = new Stack<>();

    public UserInput(InputStream in) {
        this.input = in;
    }

    /**
     * This method fill the string stack from UserInput;
     * And Starting new Thread!
     */
    public void fillStack() {
        Scanner scanner = new Scanner(input);
        Runnable runnable = () -> {
            while (scanner.hasNext()) {
                stack.push(scanner.next());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void soutStack() {
        Runnable runnable = () -> {
            while (true) {
                if (stack.empty()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(stack.pop());
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        UserInput userInput = new UserInput(System.in);
        userInput.fillStack();
        userInput.soutStack();
    }
}
