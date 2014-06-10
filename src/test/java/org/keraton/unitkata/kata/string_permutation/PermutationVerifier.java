package org.keraton.unitkata.kata.string_permutation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.*;
import org.keraton.unitkata.dummy_example.UnitKataSolutionVerifierTest;

import static org.junit.Assert.*;

/**
 * Created by bowiesanggajayabrotosumpeno on 10/06/2014.
 */
public class PermutationVerifier {

    @Solution
    private PermutationSolution permutationSolution;

    @Test
    @Order(1) @Hint("Should return 'false' when the two string doesn't have equals size")
    public void verifier_1() {
        assertFalse(permutationSolution.isPermutation("string", "string1"));
    }

    @Test
    @Order(2) @Hint("Should return 'true' when the two string are equals")
    public void verifier_2() {
        assertTrue(permutationSolution.isPermutation("string", "string"));
    }

    @Test
    @Order(3) @Hint("Should return 'false' when one letter is not found in another string")
    public void verifier_3() {
        assertFalse(permutationSolution.isPermutation("abcd", "bcde"));
    }

    @Test
    @Order(4) @Hint("Should return 'false' when the number of one letter is different in another string")
    public void verifier_4() {
        assertFalse(permutationSolution.isPermutation("aaab", "aabb"));
    }

    @Test
    @Order(5) @Hint("Should return 'true' when all the letters have the same number in both strings")
    public void verifier_5() {
        assertTrue(permutationSolution.isPermutation("baab", "aabb"));
    }
}

