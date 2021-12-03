package test.by.bakhar.task3.reader;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.reader.ConeReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ConeReaderTest {
    private final static String FILE_PATH="src\\main\\resourcesfortest\\data\\data.txt";
    @Test
    public void testReadConeFromFile() throws ConeException {
        ConeReader coneReader=new ConeReader();
        List<String> actual=coneReader.readConeFromFile(FILE_PATH);
        List<String> expected= new ArrayList<>();
        expected.add("+2.5 0 1.4 +6.5 52.14 2.6 4.");
        expected.add("2.5 15 1.4 -6.5 52.14 2.6 4.");
        Assert.assertEquals(actual,expected);
    }
}