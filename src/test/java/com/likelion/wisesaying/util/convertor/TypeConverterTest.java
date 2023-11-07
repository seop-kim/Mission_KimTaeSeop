package com.likelion.wisesaying.util.convertor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeConverterTest {
    private final TypeConverter converter = new TypeConverter();
    @DisplayName("String 형태의 정수 값을 받으면 Long으로 반환한다.")
    @Test
    void converterTest1() {
        // given
        Long result = 11L;
        // when
        Long testValue = converter.strToLong("11");
        // then
        assertThat(result)
                .isEqualTo(testValue);
    }
    @DisplayName("String 형태의 정수 값이 아니면 NumberFormatException이 발생한다.")
    @Test
    void converterTest2() {
        Assertions.assertThatThrownBy(() -> {
            converter.strToLong("II");
        }).isInstanceOf(NumberFormatException.class);
    }
}