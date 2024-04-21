package models;

import org.junit.Assert;
import org.junit.Test;

public class SneakerTests {
//    This is our test data that we will compare to the actual values returned from the object.
//    We create a new Sneaker object for testing. Then we invoke setName() passing in the test data.
//    Retrieve the objects 'name' value with getName() and compare with the value that is expected.

    @Test
    public void setNameTest(){
        //given (1)
        Sneaker testSneaker = new Sneaker();
        String expected = "OZWEEGO";

        //when (2)
        testSneaker.setName(expected);

        //then (3)
        Assert.assertEquals(expected, testSneaker.getName());
    }
    @Test //(1)
    public void constructorTest(){
        //(2)
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        //(3)
        Sneaker testSneaker = new Sneaker(expectedId, expectedName, expectedBrand, expectedSport, expectedQty, expectedPrice);

        //(4)
        Assert.assertEquals(expectedId, testSneaker.getId());
        Assert.assertEquals(expectedName, testSneaker.getName());
        Assert.assertEquals(expectedBrand, testSneaker.getBrand());
        Assert.assertEquals(expectedSport, testSneaker.getSport());
        Assert.assertEquals(expectedQty, testSneaker.getQty());
        Assert.assertEquals(expectedPrice, testSneaker.getPrice(), 0.001);
    }
}
