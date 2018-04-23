package Tracker;

public class Item {
    /*
    Лучше всего чтобы id был типа int а не String.
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreate() {
        return create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}