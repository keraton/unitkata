package org.keraton.unitkata.kata.string_permutation;

import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bowiesanggajayabrotosumpeno on 10/06/2014.
 */
public class PermutationVerifier {

    @Solution
    private PermutationSolution permutationSolution;

    @Solve(order = 1, hint = "Should return 'false' when the two string doesn't have equals size")
    public void verifier_1() {
        assertFalse(permutationSolution.isPermutation("string", "string1"));
    }

    @Solve(order = 2, hint = "Should return 'true' when the two string are equals")
    public void verifier_2() {
        assertTrue(permutationSolution.isPermutation("string", "string"));
    }

    @Solve(order = 3, hint = "Should return 'false' when one letter is not found in another string")
    public void verifier_3() {
        assertFalse(permutationSolution.isPermutation("abcd", "bcde"));
    }

    @Solve(order = 4, hint = "Should return 'false' when the number of one letter is different in another string")
    public void verifier_4() {
        assertFalse(permutationSolution.isPermutation("aaab", "aabb"));
    }

    @Solve(order = 5, hint = "Should return 'true' when all the letters have the same number in both strings")
    public void verifier_5() {
        assertTrue(permutationSolution.isPermutation("baab", "aabb"));
    }
}

