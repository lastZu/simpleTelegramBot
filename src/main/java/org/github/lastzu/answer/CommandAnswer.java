package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandAnswer extends CainAnswerFactory{
    final Logger logger = LoggerFactory.getLogger(TextAnswer.class);

    public CommandAnswer() {
        Answer empty = new EmptyAnswer();
        Answer text = new TextAnswer();
        Answer command = new KeyboardAnswer();

        setFirstAnswer(empty);
        empty.setNextAnswer(text);
        text.setNextAnswer(command);

        logger.info("Create CommandAnswer");
    }
}
