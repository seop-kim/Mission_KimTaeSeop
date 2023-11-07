package com.likelion.wisesaying.util.convertor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestConverterTest {
    private final RequestConverter converter = new RequestConverter();
    @DisplayName("삭제?id=1의 request가 들어오면 1 값을 돌려준다.")
    @Test
    void requestConverterTest() {
        // given
        Long result = 1L;
        // when
        Long testValue = converter.splitId("삭제?id=1");
        // then
        assertThat(result)
                .isEqualTo(testValue);
    }

}