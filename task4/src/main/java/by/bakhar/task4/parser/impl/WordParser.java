package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Symbol;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements ComponentParser {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void setNext(ComponentParser nextParser) {
        logger.error("setNext() is unsupported");
        throw new UnsupportedOperationException();
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.WORD) {
            for (char symbol : text.toCharArray()) {
                component.add(new Symbol(symbol, ComponentType.SYMBOl));
            }
        } else {
            logger.error("Parsing is unsupported");
            throw new ComponentException("Parsing is impossible! " + text);
        }
    }
}
