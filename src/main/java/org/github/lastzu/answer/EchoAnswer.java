package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoAnswer extends CainAnswerFactory{
    final Logger logger = LoggerFactory.getLogger(TextAnswer.class);

    public EchoAnswer() {
        Answer empty = new EmptyAnswer();
        Answer text = new TextAnswer();

        setFirstAnswer(empty);
        empty.setNextAnswer(text);

        logger.info("Create EchoAnswer");
    }
}
