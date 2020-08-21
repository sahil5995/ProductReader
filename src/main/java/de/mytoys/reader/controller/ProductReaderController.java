package de.mytoys.reader.controller;

import de.mytoys.reader.service.ProductReaderService;
import de.mytoys.reader.swagger.SwaggerAnnotatedProductReader;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
@Api(value = "/", description = "Get the product details", tags = "product-details-reader")
public class ProductReaderController implements SwaggerAnnotatedProductReader {

    private ProductReaderService productReaderService;

    public ProductReaderController(ProductReaderService productReaderService) {
        this.productReaderService = productReaderService;
    }

    @Override
    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> getProductDetails() {
        log.info("Getting the product details");
        return productReaderService.readProductDetails();
    }

}
