package strategy;

public class Paint {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void executePain() {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape shape = new Square();
        Paint paint = new Paint();
        paint.setShape(shape);
        paint.executePain();
    }
}
