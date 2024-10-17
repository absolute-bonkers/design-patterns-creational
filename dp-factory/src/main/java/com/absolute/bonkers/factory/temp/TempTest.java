package com.absolute.bonkers.factory.temp;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TempTest {
    int a;
    int b;


    public static int calculateSum(TempTest sample) {
        return sample.getA() + sample.getB();
    }
}
