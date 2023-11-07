package com.likelion.wisesaying.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.likelion.wisesaying.domain.Saying;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SayingServiceTest {
    private SayingService service;
    @BeforeEach
    void init() {
        service = new SayingService();
    }
    @AfterEach
    void close() {
        service = null;
    }
    @Test
    @DisplayName("Saying 객체를 저장하면 Long type id를 반환한다.")
    void saveTest1() {
        Long result = 1L;
        Saying saying = new Saying();
        saying.setContent("test content");
        saying.setAuthor("test author");
        Long saveId = service.save(saying);
        assertThat(result)
                .isEqualTo(saveId);
    }
}