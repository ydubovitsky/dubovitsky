package socket.bot;

import java.io.Serializable;

/**
 * All simple must implements this interface.
 */
public interface AnswersQuestions extends Serializable {
    /**
     * Return random String
     * @return
     */
    String getAnswer();
}
