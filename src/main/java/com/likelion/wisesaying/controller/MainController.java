package com.likelion.wisesaying.controller;

import com.likelion.wisesaying.language.KoreaConstContent;
import com.likelion.wisesaying.util.config.AppConfig;
import com.likelion.wisesaying.util.request.Request;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    private final Map<String, String> model = new HashMap<>();

    public void run() {
        String path = "";
        System.out.println(KoreaConstContent.START_MENU);

        // start
        while (!path.equals(KoreaConstContent.END)) {
            path = Request.input(model);
            MainCollection.getFunction(model.get("path")).process(model);
        }
    }
}