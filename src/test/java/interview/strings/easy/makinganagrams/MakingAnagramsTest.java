package interview.strings.easy.makinganagrams;

import org.junit.Assert;
import org.junit.Test;

public class MakingAnagramsTest {

    @Test
    public void makeAnagrams() {
        Assert.assertEquals(4, MakingAnagrams.makeAnagrams("cde", "abc"));
        Assert.assertEquals(2, MakingAnagrams.makeAnagrams("showman", "woman"));
        Assert.assertEquals(30, MakingAnagrams.makeAnagrams("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}