package Strategy;

public class Paint {
    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }

    public String executePain() {
        return shape.draw();
    }

    public static void main(String[] args) {
        Paint paint = new Paint(new Triangle());
        System.out.println(paint.executePain());
        paint = new Paint(new Square());
        System.out.println(paint.executePain());
    }
}
