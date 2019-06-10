package socket.bot;

import java.io.Serializable;

/**
 * All classes must implements this interface.
 */
public interface AnswersQuestions extends Serializable {
    /**
     * Return random String
     * @return
     */
    String getAnswer();
}
