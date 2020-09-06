package interview.warmup.repeatedstring;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedStringTest {

    @Test
    public void repeatedStringTest() {
        RepeatedString repeatedString = new RepeatedString();
        Assert.assertEquals(7, repeatedString.repeatedString("aba", 10));

        Assert.assertEquals(1000000000000L, repeatedString.repeatedString("a", 1000000000000L));
    }

    @Test
    public void testCase7() {
        RepeatedString repeatedString = new RepeatedString();
        Assert.assertEquals(51574523448L,
                repeatedString
                        .repeatedString(
                                "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm",
                                736778906400L));
    }
}