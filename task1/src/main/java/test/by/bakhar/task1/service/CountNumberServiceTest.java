package test.by.bakhar.task1.service;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.service.CountNumberService;
import by.bakhar.task1.service.impl.CountNumberImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountNumberServiceTest {
    CountNumberService countNumber = new CountNumberImpl();

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderInit() {
        return new Object[][]{
                {new DoubleArray(5.4, 76, 0, 1.9), 83.3, 3, 0, 20.825},
                {new DoubleArray(0, 0, 0, 0), 0., 0, 0, 0.},
                {new DoubleArray(5.4, -75.14, -75.1, 65.17), -79.67, 2, 2, -19.9175},
                {new DoubleArray(5.4, 76, 0, 45.4), 126.8, 3, 0, 31.7},
                {new DoubleArray(-5.4, 0, 1, 49), 44.6, 2, 1, 11.15}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testCountSum(Object[] data) throws DoubleArrayException {
        double expected = (double) data[1];
        double actual = countNumber.countSum((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual, 0.000001);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountSumDoubleStream(Object[] data) throws DoubleArrayException {
        double expected = (double) data[1];
        double actual = countNumber.countSumDoubleStream((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual, 0.0000001);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountPositive(Object[] data) throws DoubleArrayException {
        int expected = (int) data[2];
        DoubleArray array = (DoubleArray) data[0];
        int actual = countNumber.countPositive(array);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountPositiveDoubleStream(Object[] data) throws DoubleArrayException {
        long expected = (long) ((int) data[2]);
        DoubleArray array = (DoubleArray) data[0];
        long actual = countNumber.countPositiveDoubleStream(array);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountNegative(Object[] data) throws DoubleArrayException {
        int expected = (int) data[3];
        DoubleArray array = (DoubleArray) data[0];
        int actual = countNumber.countNegative(array);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountNegativeDoubleStream(Object[] data) throws DoubleArrayException {
        long expected = (long) ((int) data[3]);
        DoubleArray array = (DoubleArray) data[0];
        long actual = countNumber.countNegativeDoubleStream(array);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountAverage(Object[] data) throws DoubleArrayException {
        double expected = (double) data[4];
        DoubleArray array=(DoubleArray) data[0];
        double actual = countNumber.countAverage(array);
        Assert.assertEquals(expected,actual,0.00001);
    }

    @Test(dataProvider = "dataProvider")
    public void testCountAverageDoubleStream(Object[] data) throws DoubleArrayException {
        double expected = (double) data[4];
        DoubleArray array=(DoubleArray) data[0];
        double actual = countNumber.countAverageDoubleStream(array);
        Assert.assertEquals(expected,actual,0.00001);
    }
}