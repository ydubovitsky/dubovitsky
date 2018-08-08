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
        for (int i = 0; i < persons.size(); i++) {
            String str = String.join("", persons.get(i).getList());
            if (str.contains(key)) {
                result.add(persons.get(i));
            }
            //System.out.println(str);
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Иван", "Дулин", "03", "Челябинск"));
        phoneDictionary.add(new Person("Иван", "Дулин", "03", "Челябинск"));
        System.out.println(phoneDictionary.find("Иван"));
    }
}

