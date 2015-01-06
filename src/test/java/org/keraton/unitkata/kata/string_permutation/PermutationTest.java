package org.keraton.unitkata.kata.string_permutation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

/**
 * Created by bowiesanggajayabrotosumpeno on 10/06/2014.
 */
@RunWith(UnitKataRunner.class)
@Verifier(value = PermutationVerifier.class, showHint = false)
@Summary(   "You need to implement the isPermutation(String string, String permutation) \n"
            + "which return true two string is permutation of one another"
        )
public class PermutationTest {

    @Solution
    private PermutationSolution permutationSolution;

    @Test
    public void hello_test() {

    }

}
