package interview.strings.easy.alternatingcharacters;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlternatingCharactersTest {

    @Test
    public void alternatingCharacters() {
        assertEquals(3, AlternatingCharacters.alternatingCharacters("AAAA"));
        assertEquals(4, AlternatingCharacters.alternatingCharacters("BBBBB"));
        assertEquals(0, AlternatingCharacters.alternatingCharacters("ABABABAB"));
        assertEquals(0, AlternatingCharacters.alternatingCharacters("BABABA"));
        assertEquals(4, AlternatingCharacters.alternatingCharacters("AAABBB"));
    }
}