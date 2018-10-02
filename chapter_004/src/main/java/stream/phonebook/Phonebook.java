package stream.phonebook;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс абонентов.
 */
class Person {

    /**
     * Члены класса "абонент";
     * Имя, Фамилия, Телефо, Адрес.
     */
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Конструктор класса.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
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
     * Переопределныый метод toString.
     * @return
     */
    @Override
    public String toString() {
        return "В телефонной книге есть:" + System.lineSeparator() +
                "Имя = " + this.getName() + System.lineSeparator() +
                "Фамилия = " + this.getSurname() + System.lineSeparator() +
                "Телефон = " + this.getPhone() + System.lineSeparator() +
                "Адрес = " + this.getAddress() + System.lineSeparator();
    }
}

public class Phonebook {

    /**
     * Список абонентов.
     */
    public List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавляет нового абонента в ТС.
     * @param person - абонент.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод производит поиск по очереди по всем 4 полям телефонного справочника по ключу key;
     * @param key - ключ для поиска.
     */
    public List<Person> find(String key) {
        List<Person> list = persons.stream().filter(
                name -> name.getName().contains(key)).collect(Collectors.toList());
        list.addAll(persons.stream().filter(
                surname -> surname.getSurname().contains(key)).collect(Collectors.toList()));
        list.addAll(persons.stream().filter(
                phone -> phone.getPhone().contains(key)).collect(Collectors.toList()));
        list.addAll(persons.stream().filter(
                adress -> adress.getAddress().contains(key)).collect(Collectors.toList())
        );
        //list.forEach(System.out::println);
        return list;
    }
}

