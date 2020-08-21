package de.mytoys.reader.utils;

import de.mytoys.reader.exception.custom.FileParserError;
import de.mytoys.reader.model.ProductResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsTest {

    @Autowired
    private CustomCSVReader customCSVReader;

    @Test
    public void testGetProductDetailsFromCSV() {

        //Arrange and Act
        List<Object> response = customCSVReader.getProductDetailsFromCSV(ProductResponse.class, "data/product_data.csv");

        //Assert
        Assert.assertNotNull(response);

    }

    @Test(expected = FileParserError.class)
    public void testGetProductDetailsFromCSVException() {

        //Act and Assert
        customCSVReader.getProductDetailsFromCSV(ProductResponse.class, "wrong file path");
    }
}
