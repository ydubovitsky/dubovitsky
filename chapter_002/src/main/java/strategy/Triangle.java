package strategy;

interface MyFunInterface<T extends String> {
    T myMeth();
}

public class Triangle implements Shape {
    private MyFunInterface<String> myFunInterface = () -> {
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < 7; j++) {
            for (int i = j; i > 0; i--) {
                sb.append("+");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    };

    public String draw() {
        return myFunInterface.myMeth();
    }
}
