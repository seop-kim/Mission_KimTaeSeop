package com.likelion.wisesaying.database;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.repository.jdbc.SayingDAO;
import org.junit.jupiter.api.Test;

class SayingDbConTest {

    @Test
    void register() {
        SayingDAO sayingDbCon = new SayingDAO();

        Saying saying = new Saying();
//        saying.setId(1L);
//        saying.setContent("hello");
//        saying.setAuthor("likelion");
        sayingDbCon.save(saying);
    }

}