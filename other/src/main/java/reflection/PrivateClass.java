package reflection;

/**
 * Класс с приватными методами и полями;
 * Для отработки Reflection.
 */
public class PrivateClass {

    private int number;
    private String name = "default";

    public PrivateClass() {

    }

    public PrivateClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public PrivateClass(Object o, PrivateClass pc, Class cl) {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void justLikeToTestReflection(Object o, String s, Class c) {

    }

    private void printData(){
        System.out.println("number = " + number + " name = " + name);
    }
}

