package de.mytoys.reader.controller;

import de.mytoys.reader.service.impl.ProductReaderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProductReaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductReaderServiceImpl service;

    @Test
    public void testGetProductDetailsSuccess() throws Exception {

        //Arrange
        ReflectionTestUtils.setField(service, "productFilePath", "data/product_data.csv");

        //Act & Assert
        mockMvc.perform(get("/product").contentType(MediaType.APPLICATION_JSON)).
                andDo(print()).andExpect(status().isOk()).
                andExpect(jsonPath("$[0].id").exists()).
                andExpect(jsonPath("$[0].name").exists());

    }

    @Test
    public void testGetProductDetailsError() throws Exception {

        //Arrange
        ReflectionTestUtils.setField(service, "productFilePath", "wrong file path");

        //Act & Assert
        mockMvc.perform(get("/product").contentType(MediaType.APPLICATION_JSON)).
                andDo(print()).andExpect(status().isInternalServerError()).
                andExpect(jsonPath("$.message", is("Error occurred while reading the CSV file")));
    }


}
