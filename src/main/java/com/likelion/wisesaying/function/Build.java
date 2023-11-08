package com.likelion.wisesaying.function;

import com.likelion.wisesaying.controller.IMainControllable;
import java.util.Map;

public class Build implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        service.build();
    }

}
