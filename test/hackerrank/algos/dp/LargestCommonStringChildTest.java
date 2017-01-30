package hackerrank.algos.dp;
import org.junit.Assert;
import org.junit.Test;

public class LargestCommonStringChildTest {
    
    @Test
    public void test_WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS_FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC_15() {
        String one = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
        String two = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";
        executeAndAssert(one, two, 15);
    }
    
    @Test public void test_blank_blank_0() { executeAndAssert("", "", 0); }
    @Test public void test_A_B_0() { executeAndAssert("A", "B", 0); }
    @Test public void test_A_A_1() { executeAndAssert("A", "A", 1); }
    @Test public void test_A_AB_1() { executeAndAssert("A", "AB", 1); }
    @Test public void test_AB_AB_2() { executeAndAssert("AB", "AB", 2); }
    @Test public void test_AA_AB_1() { executeAndAssert("AA", "AB", 1); }
    @Test public void test_AA_BB_0() { executeAndAssert("AA", "BB", 0); }
    @Test public void test_ABCD_ABDC_3() { executeAndAssert("ABCD", "ABDC", 3); }
    @Test public void test_SALLY_HARRY_2() { executeAndAssert("SALLY", "HARRY", 2); }
    @Test public void test_SHINCHAN_NOHARAAA_3() { executeAndAssert("SHINCHAN", "NOHARAAA", 3); }

    private void executeAndAssert(String a, String b, int expectedLength) {
        int length = new LargestCommonStringChild(a, b).getLCS();
        Assert.assertEquals(expectedLength, length);
    }
}
