package org.keraton.unitkata.kata.string_permutation.cheat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bowiesanggajayabrotosumpeno on 10/06/2014.
 *
 * Write a methods that test is one string is permutation of another
 */
public class PermutationCheat {

    public boolean isPermutation(String string, String permutation) {
        if (string.length() != permutation.length())
            return false;
        if (string.equals(permutation))
            return true;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<string.length(); i++) {
            char c1 = string.charAt(i);
            char c2 = permutation.charAt(i);
            map.put(c1, map.get(c1) == null ? 1 : map.get(c1)+1);
            map.put(c2, map.get(c2) == null ? -1 : map.get(c2)-1);
        }

        for(Integer count : map.values()) {
            if (count != 0) return false;
        }

        return true;
    }
}
