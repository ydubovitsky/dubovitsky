package strategy;

public class Square implements Shape {
    private int squareHight = 4;

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());
    }

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        for (int i = 0; i <= squareHight; i++) {
            if (i == 0 || i == squareHight) {
                pic.append("+++++++");
                pic.append(System.lineSeparator());
            } else {
                pic.append("+     +");
                pic.append(System.lineSeparator());
            }
        }
        return pic.toString();
    }
}
