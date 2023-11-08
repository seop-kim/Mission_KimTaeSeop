package com.likelion.wisesaying.util.convertor;

import com.likelion.wisesaying.util.exception.CustomRequestException;

public class RequestConverter {

    public String[] splitId(String request) throws IndexOutOfBoundsException {
        if (request.contains("?id=")) {
            return request.split("\\?id=");
        }

        return new String[]{request, ""};
    }
}