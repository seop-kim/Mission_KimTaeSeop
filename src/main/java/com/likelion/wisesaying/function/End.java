package com.likelion.wisesaying.function;

import com.likelion.wisesaying.controller.IMainControllable;
import java.util.Map;

public class End implements IMainControllable {
    @Override
    public void process(Map<String, String> model) {
        // service.txtSave(); DB 저장으로 인한 주석
    }
}
