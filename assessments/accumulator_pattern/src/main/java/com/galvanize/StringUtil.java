package com.galvanize;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public static HashMap<Character,Integer> charsInBoth(String a, String b) {
        HashMap<Character,Integer> output = new HashMap<>();
        String both = a + b;
        for(char chr : both.toCharArray()) {
            if(!output.containsKey(chr)) {
                output.put(chr, 0);
            }
            output.put(chr, output.get(chr) + 1);
        }
        return output;
    }
}
