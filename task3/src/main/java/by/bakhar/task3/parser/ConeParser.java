package by.bakhar.task3.parser;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.factory.ConeFactoryParameters;
import by.bakhar.task3.validation.ConeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeParser {
    private static Logger logger = LogManager.getLogger();
    private final static String SPACE_REGEX = " ";

    public double[] parseString(String data) throws ConeException {
        if (!ConeStringValidator.isStringValid(data)) {
            logger.error("wrong data " + data);
            throw new ConeException("wrong data " + data);
        }
        double[] result = new double[ConeFactoryParameters.NUMBER_OF_PARAMS];
        String[] values = data.split(SPACE_REGEX);
        for (int i = 0; i < ConeFactoryParameters.NUMBER_OF_PARAMS; i++) {
            result[i] = Double.parseDouble(values[i]);
        }
        return result;
    }
}
