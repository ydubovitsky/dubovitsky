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
     * Если хеш-коды разные, то и входные объекты гарантированно разные.
     * @return - хэш-код.
     */
    @Override
    public int hashCode() {
        return Integer.parseInt(getAddress() + getName() + getPhone() + getSurname());
    }

    /**
     * Метод сравнивает содержимое объектов и выводит значение типа boolean true,
     * если содержимое эквивалентно, и false — если нет.
     * @param o - объект для сравнения.
     * @return - true/false.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = true;
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        // Использую == и equals.
        if ((address.equals(person.address)) && (name.equals(person.name)) &&
                (phone.equals(person.phone)) && (surname == person.surname)) {
            equals = true;
        } else {
            equals = false;
        }
        return equals;
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
                "Адрес = " + this.getAddress();
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
                address -> address.getAddress().contains(key)).collect(Collectors.toList())
        );
        //list.forEach(System.out::println);
        return list;
    }
}

