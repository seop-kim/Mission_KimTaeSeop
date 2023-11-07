package com.likelion.wisesaying.util.convertor;

import com.likelion.wisesaying.util.exception.CustomRequestException;

public class RequestConverter {
    private final TypeConverter typeConverter = new TypeConverter();
    public Long splitId(String request) throws IndexOutOfBoundsException {
        String[] splitStr = request.split("\\?id=");
        try {
            return typeConverter.strToLong(splitStr[1]);
        } catch (IndexOutOfBoundsException e) {
            throw new CustomRequestException();
        }
    }
}