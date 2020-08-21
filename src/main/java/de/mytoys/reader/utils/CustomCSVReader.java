package de.mytoys.reader.utils;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.mytoys.reader.exception.custom.FileParserError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Slf4j
@Component
public class CustomCSVReader {

    /**
     * This is a generic method which is used to read the CSV file
     *
     * @param type        type of the product details to be returned
     * @param csvFilePath path of CSV file to be read
     * @return List
     */
    public List<Object> getProductDetailsFromCSV(Class type, String csvFilePath) {
        try (Reader reader = new BufferedReader(new FileReader(csvFilePath))) {
            CsvToBean<Object> genericBean = new CsvToBeanBuilder(reader).withType(type).build();
            var productsList = genericBean.parse();

            log.info("Returning the product details list with size {}", productsList.size());
            return productsList;
        } catch (IOException ex) {
            throw new FileParserError("Error occurred while reading the CSV file");
        }
    }
}
