package com.likelion.wisesaying.util.convertor;

public class RequestConverter {

    public String[] splitId(String request) throws IndexOutOfBoundsException {
        if (request.contains("?id=")) {
            return request.split("\\?id=");
        }

        return new String[]{request, ""};
    }
}