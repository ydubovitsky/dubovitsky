package stream.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhonebookTest {

    Phonebook phonebook = new Phonebook();

    @Before
    public void setUp() throws Exception {
        phonebook.add(new Person("Петр", "Первый",
                "123-45-65", "Kiev"));
        phonebook.add(new Person("Вася", "Первый",
                "123-45-65", "Нью-Йорк"));
        phonebook.add(new Person("Вася", "Первый",
                "123-45-65", "Москва"));
        phonebook.add(new Person("Конор Маклауд", "Первый",
                "123-45-65", "Новгород"));
    }

    @Test
    public void find() throws Exception {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Вася", "Первый",
                "123-45-65", "Москва"));
        //assertThat(phonebook.find("Москва"), is(expected));
        //Assert.assertEquals(phonebook.find("Москва"), is(expected));
        Assert.assertEquals(expected, phonebook.find("Москва"));
    }
}