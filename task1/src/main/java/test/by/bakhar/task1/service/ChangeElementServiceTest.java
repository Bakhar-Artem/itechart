package test.by.bakhar.task1.service;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.service.ChangeElementService;
import by.bakhar.task1.service.impl.ChangeElementImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChangeElementServiceTest {
    ChangeElementService changeElement=new ChangeElementImpl();
    @Test
    public void testChangeElement() throws DoubleArrayException {
        DoubleArray array=new DoubleArray(-45.,49.2,0.,105.,14);
        int start=1;
        int finish=3;
        double x=15.2;
        double[] expectedArray={-45.,15.2,15.2,15.2,14};
        changeElement.changeElement(array,start,finish,x);
        double[] actualArray=array.getArray();
        assertEquals(expectedArray,actualArray);
    }
    @Test(expectedExceptions = DoubleArrayException.class)
    public void testDoubleArrayException() throws DoubleArrayException {
        DoubleArray doubleArray=new DoubleArray(5.4,72.);
        changeElement.changeElement(doubleArray,0,3,0.5);
    }
}