package com.galvanize;

import java.util.ArrayList;
import java.util.List;

public class NumberListUtil {

    public List<Integer> findMissingNumbers(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        for(Integer ai : a) {
            if(b.indexOf(ai) < 0) {
                result.add(ai);
            }
        }
        return result;
    }
}
