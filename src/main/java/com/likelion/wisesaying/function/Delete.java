package com.likelion.wisesaying.function;

import com.likelion.wisesaying.controller.IMainControllable;
import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.util.exception.CustomRequestException;
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

        } catch (CustomRequestException e) {
            return;
        }

        System.out.println(deleteId + KoreaContent.DELETE_MSG);
    }
}
