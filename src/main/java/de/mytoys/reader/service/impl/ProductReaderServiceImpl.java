package de.mytoys.reader.service.impl;

import de.mytoys.reader.model.ProductResponse;
import de.mytoys.reader.service.ProductReaderService;
import de.mytoys.reader.utils.CustomCSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReaderServiceImpl implements ProductReaderService {

    @Value("${path.productFile}")
    private String productFilePath;

    private CustomCSVReader customCSVReader;

    public ProductReaderServiceImpl(CustomCSVReader customCSVReader) {
        this.customCSVReader = customCSVReader;
    }

    /**
     * Method returns the product details read from CSV file
     *
     * @return List
     */
    public List<Object> readProductDetails() {
        return customCSVReader.getProductDetailsFromCSV(ProductResponse.class, productFilePath);
    }

}
