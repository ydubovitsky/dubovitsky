package socket.bot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class AnswersTest {

    Answers answers;

    @BeforeEach
    void setUp() {
        this.answers = new Answers();
    }

    @RepeatedTest(10)
    void getAnswer() {
        System.out.println(this.answers.getAnswer());
    }
}