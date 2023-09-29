package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoMessageAnswer extends CainAnswerFactory{
    final Logger logger = LoggerFactory.getLogger(EchoAnswer.class);

    public EchoMessageAnswer() {
        Answer empty = new EmptyAnswer();
        Answer text = new EchoAnswer(empty);

        setAnswer(text);

        logger.info("Create EchoAnswer");
    }
}
