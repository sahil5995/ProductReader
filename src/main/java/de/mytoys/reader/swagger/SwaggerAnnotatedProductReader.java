package de.mytoys.reader.swagger;

import de.mytoys.reader.model.ProductResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

/**
 * Swagger Documentation
 */
public interface SwaggerAnnotatedProductReader {


    @ApiOperation(value = "Read product details",
            responseContainer = "List", response = ProductResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
    })
    List<Object> getProductDetails();

}