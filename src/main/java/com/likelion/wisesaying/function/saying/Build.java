package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.function.IMainControllable;
import java.util.Map;

public class Build implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        service.build();
    }

}
