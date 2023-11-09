package com.likelion.wisesaying.function;

import com.likelion.wisesaying.service.SayingService;
import java.util.Map;
import java.util.Scanner;

public interface IMainControllable {
    SayingService service = new SayingService();

    void process(Map<String, String> model);
}
