package com.absolute.bonkers.builder.temp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TempTestTest {

    @Test
    void testSum() {

        TempTest sample = TempTest.builder().a(10).b(5).build();
        int result = TempTest.calculateSum(sample);
        Assertions.assertThat(result).isEqualTo(15);

    }
}