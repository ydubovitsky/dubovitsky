package threads.pong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Класс, реализующий приложение пинг-понг.
 */
public class PingPong extends Application {

    private static final String JOB4J = "Пинг-понг";
    private Thread thread;

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(150, 150, 10, 10);
        group.getChildren().add(rect);
        thread = new Thread(new RectangleMove(rect));
        thread.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.setOnCloseRequest(
                event -> thread.interrupt()// execute interrupt
        );
        stage.show();
    }
}

