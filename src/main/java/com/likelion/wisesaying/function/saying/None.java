package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.language.KoreaConstContent;
import java.util.Map;

public class None implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        System.out.println(KoreaConstContent.NONE_COMMEND);
    }
}
