package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.language.KoreaConstContent;
import java.util.Map;

public class Find implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        System.out.println(KoreaConstContent.LIST_GUIDE_MSG);
        for (Saying saying : service.findAllReverse()) {
            System.out.println(saying.getId() + "\t/\t" + saying.getAuthor() + "\t/\t" + saying.getContent());
        }
    }
}
