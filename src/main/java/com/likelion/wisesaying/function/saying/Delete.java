package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.language.KoreaConstContent;
import java.util.Map;

public class Delete implements IMainControllable {


    @Override
    public void process(Map<String, String> model) {
        Long deleteId;

        try {
            deleteId = service.delete(model.get("id"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(deleteId + KoreaConstContent.DELETE_MSG);
    }
}
