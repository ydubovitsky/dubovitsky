package ru.job4j.condition;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Y Dubovitsky (y.dubovitsky@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {
    /**
     * Ссылка на объект Bot.
     */
    private DummyBot bot;

    @Before
    public void initBot() {
        bot = new DummyBot();
    }

    @Test
    public void whenGreetBot() {
        assertThat(
                bot.answer("Привет, Бот"),
                is("Привет, умник.")
        );
    }

    @Test
    public void whenByuBot() {
        assertThat(
                bot.answer("Пока."),
                is("До скорой встречи.")
        );
    }

    @Test
    public void whenUnknownBot() {
        assertThat(
                bot.answer("Привет дорогой, как дела?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}
