package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.util.request.Request;
import java.util.Map;

public class Register implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        System.out.print(KoreaContent.REQUEST_CONTENT);
        String requestContent = Request.input();

        System.out.print(KoreaContent.REQUEST_AUTHOR);
        String requestAuthor = Request.input();

        Saying saying = new Saying(requestContent,requestAuthor);

        Long saveId = service.save(saying);

        System.out.println(saveId + KoreaContent.RESISTER_SUCCESS_MSG);
    }
}
