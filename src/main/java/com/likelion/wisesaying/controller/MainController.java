package com.likelion.wisesaying.controller;

import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.util.request.Request;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    private final Map<String, String> model = new HashMap<>();

    public void run() {
        String path = "";
        System.out.println(KoreaContent.START_MENU);

        // start
        while (!path.equals(KoreaContent.END)) {
            path = getRequest();
            MainCollection.getFunction(model.get("path")).process(model);
        }
    }

    //
    // 문자열과 문자열 상수와는 메모리 영역에서 처리되는게 다르다. (찾아봐야함)

    private String getRequest() {
        System.out.print(KoreaContent.REQUEST_MENU);
        String request = Request.input();
        model.put("request", request);
        Request.setModel(model);
        return request;
    }
}