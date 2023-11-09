package com.likelion.wisesaying.util.request;

import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.util.convertor.RequestConverter;
import java.util.Map;
import java.util.Scanner;

public class Request {
    public static String input() {
        return new Scanner(System.in).nextLine();
    }

    public static String input(Map<String, String> model) {
        System.out.print(KoreaContent.REQUEST_MENU);
        String request = Request.input();
        model.put("request", request);
        Request.setModel(model);
        return request;
    }

    private static void setModel(Map<String, String> model) {
        RequestConverter RqConverter = new RequestConverter();
        String[] rq = RqConverter.splitId(model.get("request"));

        String path = rq[0];
        String id = rq[1];

        model.put("path", path);
        model.put("id", id);
    }
}
