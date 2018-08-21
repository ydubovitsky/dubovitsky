package phone.dictionary;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String[] list;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.list = new String[]{name, surname, phone, address};
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Возвращает массив свойств объекта.
     * @return
     */
    public String[] getList() { return  list; }
}
