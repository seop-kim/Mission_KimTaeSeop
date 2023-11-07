package com.likelion.wisesaying.util.convertor;

public class RequestConverter {
    private final TypeConverter typeConverter = new TypeConverter();
    public Long splitId(String request) {
        String[] splitStr = request.split("=");
        return typeConverter.strToLong(splitStr[1]);
    }
}