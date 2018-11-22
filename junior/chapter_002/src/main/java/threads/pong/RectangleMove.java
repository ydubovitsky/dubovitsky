package threads.pong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            while (this.rect.getX() < 300) {
                this.move(5);
            }
            while (this.rect.getX() > 0) {
                this.move(-5);
            }
        }
    }

    /**
     * Метод отвечает за перемещение.
     * @param offset - величина смещение.
     */
    private void move(int offset) {
        this.rect.setX(this.rect.getX() + offset);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
