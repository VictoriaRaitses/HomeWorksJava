import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MapSetHWTest {


    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals(Arrays.asList("Ivan", "Maria", "Piotr", "Anna")
                , MapSetHW.removeDuplicates(Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan")));
    }


    @Test
    public void testGetDuplicates() {
        Assert.assertEquals(Arrays.asList("Maria", "Ivan")
                , MapSetHW.getDuplicates(Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan")));

    }

    @Test
    public void testGetSumValues() {
        Assert.assertEquals(
                new HashMap<String, String>() {{
                    put("a", "Hi");
                    put("b", "there");
                    put("ab", "Hithere");

                }}
                , MapSetHW.getSumValues(new HashMap<String, String>() {{
                    put("a", "Hi");
                    put("b", "there");
                }}));
    }

    @Test
    public void testIsDuplicate() {
        Assert.assertEquals(new HashMap<String, Boolean>() {{
                                put("a", false);
                                put("b", true);
                            }}
                , MapSetHW.isDuplicate(new String[]{"a", "b", "b"}));

        Assert.assertEquals(new HashMap<String, Boolean>() {{
                                put("a", false);
                                put("b", false);
                            }}
                , MapSetHW.isDuplicate(new String[]{"a", "b"}));
    }

    @Test
    public void testGetAnagrams() {
        List anagrams = Arrays.asList("ivan", "vani", "piotr", "naan", "navi");
        Assert.assertEquals(
                Arrays.asList("naan")
                , MapSetHW.getAnagrams(anagrams, "anna"));
        Assert.assertEquals(
                Arrays.asList("vani", "navi")
                , MapSetHW.getAnagrams(anagrams, "ivan"));
    }

    @Test
    public void testGetNumberOfRepetitionsByName() {
        List anagrams = Arrays.asList("vani", "vani", "piotr", "vani", "navi");
        Assert.assertEquals(
                3
                , MapSetHW.getNumberOfRepetitionsByName(anagrams, "vani"));
        Assert.assertEquals(
                0
                , MapSetHW.getNumberOfRepetitionsByName(anagrams, "vaniiii"));
    }

    @Test
    public void testGetMostRepeatedWord() {
        String text = "Я люблю море.Я лечу на море.Я умею плавать,в море.Какое чистое море.";
        Set<String> prepositions = new HashSet<>(Arrays.asList(
                "в", "без", "до", "из", "к", "на", "по", "о", "от", "перед"
                , "при", "через", "с", "у", "за", "над", "об", "под", "про", "для"));
        Assert.assertEquals(
                "море"
                , MapSetHW.getMostRepeatedWord(text, prepositions));
    }
}