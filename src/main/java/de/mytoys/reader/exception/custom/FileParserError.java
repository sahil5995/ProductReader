package de.mytoys.reader.exception.custom;

public class FileParserError extends RuntimeException {

    public FileParserError(String message) {
        super(String.format(message));
    }

}
