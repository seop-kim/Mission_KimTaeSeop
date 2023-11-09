package com.likelion.wisesaying.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdGeneratorTest {
    IdGenerator generator = new IdGenerator();
    @Test
    @DisplayName("id 생성기 사용 시 최초의 값은 1이다.")
    void generatorTest1() {
        Long result = 1L;
        Long testId = generator.createId();
        assertThat(result)
                .isEqualTo(testId);
    }
    @Test
    @DisplayName("id 생성기를 n번 사용하면 마지막 번호는 n이다.")
    void generatorTest2() {
        // given
        Long result = 10L;
        // when
        Long testId = 0L;
        for (int i = 0; i < 10; i++) {
            testId = generator.createId();
        }
        // then
        assertThat(result)
                .isEqualTo(testId);
    }
}