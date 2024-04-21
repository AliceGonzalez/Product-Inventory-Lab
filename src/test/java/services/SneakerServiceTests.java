package services;

import models.Sneaker;
import org.junit.Assert;
import org.junit.Test;

public class SneakerServiceTests {
    @Test
    public void createTest(){
        //(1)
        String expectedName = "Stan Smith";
        String expectedBrand ="Adidas";
        String expectedSport = "Tennis";
        int expectedSize = (int) 10.5;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        //(2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = SneakerService.create(expectedName, expectedBrand,expectedSport, expectedSize, expectedQty, expectedPrice);

        //(3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        int actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        //(4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSport, actualSport);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice);

    }
}
