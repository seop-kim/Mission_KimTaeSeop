package com.likelion.wisesaying.util.gson;

import com.google.gson.Gson;
import com.likelion.wisesaying.domain.Saying;
import java.util.List;

public class GsonDataConverter {
    public String sayingToJson(List<Saying> sayings) {
        return new Gson().toJson(sayings);
    }
}
