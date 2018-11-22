package threads.pong;

import javafx.scene.shape.Rectangle;

/**
 * Класс, отвечающий за перемещение мячика.
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (this.rect.getX() < 300 && !Thread.currentThread().isInterrupted()) {
                this.move(5);
            }
            while (this.rect.getX() > 0 && !Thread.currentThread().isInterrupted()) {
                this.move(-5);
            }
        }
    }

    /**
     * Метод отвечает за перемещение.
     *
     * @param offset - величина смещение.
     */
    private void move(int offset) {
        this.rect.setX(this.rect.getX() + offset);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Упс, вы нажали кнопку Выход! Нить прекращает работу!");
            Thread.currentThread().interrupt();
        }
    }
}
