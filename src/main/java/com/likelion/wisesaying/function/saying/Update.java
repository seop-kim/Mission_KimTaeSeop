package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.language.KoreaConstContent;
import com.likelion.wisesaying.util.request.Request;
import java.util.Map;

public class Update implements IMainControllable {

    @Override
    public void process(Map<String, String> model) {
        Saying saying;

        try {
            saying = service.updateConfirm(model.get("id"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(KoreaConstContent.UPDATE_REQUEST_CONTENT+ saying.getContent());
        System.out.print(KoreaConstContent.REQUEST_CONTENT);
        String updateContent = Request.input();

        System.out.println(KoreaConstContent.UPDATE_REQUEST_AUTHOR + saying.getAuthor());
        System.out.print(KoreaConstContent.REQUEST_AUTHOR);
        String updateAuthor = Request.input();

        saying.updateSaying(updateContent, updateAuthor);

        service.update(saying);
    }
}
