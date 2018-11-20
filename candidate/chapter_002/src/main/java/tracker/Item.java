package tracker;

public class Item {

    /**
     * Переменные класса, характеризующие заявку.
     */
    private int id;
    private String name;
    private String desc;
    private long create;
    private String comments;

    public Item(String name, String desc, long create, String comments) {
        this.name = name;
        this.desc = desc;
        this.create = create;
        this.comments = comments;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
}