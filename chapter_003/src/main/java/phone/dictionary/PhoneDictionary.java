package phone.dictionary;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < this.persons.size(); i++) {
            if (persons.get(i).getName().contains(key)) {
                result.add(persons.get(i));
            }
            if (persons.get(i).getAddress().contains(key)) {
                result.add(persons.get(i));
            }
            if (persons.get(i).getPhone().contains(key)) {
                result.add(persons.get(i));
            }
            if (persons.get(i).getSurname().contains(key)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }
}

