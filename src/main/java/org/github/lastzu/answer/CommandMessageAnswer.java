package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandMessageAnswer extends CainAnswerFactory{
    final Logger logger = LoggerFactory.getLogger(EchoAnswer.class);

    public CommandMessageAnswer() {
        Answer empty = new EmptyAnswer();
        Answer text = new EchoAnswer(empty);
        Answer command = new KeyboardAnswer(text);

        setAnswer(command);

        logger.info("Create CommandMessageAnswer");
    }
}
