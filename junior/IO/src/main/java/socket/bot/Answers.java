package socket.bot;

import com.sun.tools.javac.util.List;

/**
 * This class contain answer for client questions.
 */
public class Answers implements AnswersQuestions{

    private List<String> answers = List.of(
            "На публику играешь?",
            "Пиара не хватает?",
            "Это все на что ты способен?",
            "Зачем мне делать из тебя дурачка?!",
            "Я работаю с уже готовым материалом.",
            "Бабайку вами в детстве не пугали?",
            "У тебя вагон здоровья? Так, сейчас разгрузим…",
            "У тебя что, хромосома лишняя?",
            "Уходите? Зачем же так неспешно?!",
            "А тебе не тяжело будет поломанными руками зубы с пола собирать?",
            "Ты это только что придумал, или у тебя там карточки с заготовками?",
            "Это набор слов, или мне нужно вдуматься?);");

    /**
     * Method for getting random value from min to max.
     */
    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * This method return random answers from list.
     */
    public String getAnswer() {
        return answers.get(this.rnd(0, this.answers.length() - 1));
    }
}
