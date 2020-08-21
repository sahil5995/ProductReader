package de.mytoys.reader.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ProductResponse {

    @CsvBindByName
    private Long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private Double old_price;

    @CsvBindByName
    private Long stock;

    @CsvBindByName
    private String brand;

}
