package de.mytoys.reader.service;

import de.mytoys.reader.service.impl.ProductReaderServiceImpl;
import de.mytoys.reader.utils.CustomCSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductReaderServiceImplTest {

    @InjectMocks
    private ProductReaderServiceImpl productReaderService;

    @Mock
    private CustomCSVReader customCSVReader;

    @Test
    public void testReadProductDetails() {

        //Arrange
        ReflectionTestUtils.setField(productReaderService, "productFilePath", "data/product_data.csv");

        //Act
        productReaderService.readProductDetails();

        //Assert
        verify(customCSVReader, times(1)).getProductDetailsFromCSV(any(), anyString());

    }
}
