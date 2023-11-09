package com.likelion.wisesaying.function.saying;

import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.repository.obj.SayingRepository;
import com.likelion.wisesaying.service.SayingService;
import java.util.Map;

public class End implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        if (SayingService.getDBType() instanceof SayingRepository) {
            service.txtSave();
        }
    }
}
