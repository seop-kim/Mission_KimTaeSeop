package com.likelion.wisesaying.function;

import com.likelion.wisesaying.controller.IMainControllable;
import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.util.exception.CustomRequestException;
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
        } catch (CustomRequestException e) {
            return;
        }

        System.out.println(KoreaContent.UPDATE_REQUEST_CONTENT+ saying.getContent());
        System.out.print(KoreaContent.REQUEST_CONTENT);
        String updateContent = Request.input();
        saying.setContent(updateContent);

        System.out.println(KoreaContent.UPDATE_REQUEST_AUTHOR + saying.getAuthor());
        System.out.print(KoreaContent.REQUEST_AUTHOR);
        String updateAuthor = Request.input();
        saying.setAuthor(updateAuthor);

        service.update(saying);
    }
}
