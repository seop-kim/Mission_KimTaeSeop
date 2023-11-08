package com.likelion.wisesaying.util.request;

import com.likelion.wisesaying.util.convertor.RequestConverter;
import java.util.Map;
import java.util.Scanner;

public class Request {
    public static String input() {
        return new Scanner(System.in).nextLine();
    }

    public static Map<String, String> setModel(Map<String, String> request) {
        RequestConverter RqConverter = new RequestConverter();
        String[] rq = RqConverter.splitId(request.get("request"));

        String path = rq[0];
        String id = rq[1];

        request.put("path", path);
        request.put("id", id);

        return request;
    }
}
