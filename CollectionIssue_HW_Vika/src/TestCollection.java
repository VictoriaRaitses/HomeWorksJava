import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestCollection {
    @Test
    public void testNamesLongerThanFour() {
        List<String> actual = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia");
        List<String> expected = Arrays.asList("Maria", "Stephan", "Amalia");
        Assert.assertEquals(expected, Collection.getNamesLongerThanFour(actual));
    }

    @Test
    public void testComparedLists() {
        Assert.assertEquals(Arrays.asList("yes", "yes", "no", "yes"),
                Collection.compareLists(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2, 9, 4)));

        Assert.assertEquals(Arrays.asList(),
                Collection.compareLists(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 9, 4)));
    }

    @Test
    public void testCycle() {
        List<String> firstList = Arrays.asList("aa", "bb", "cc", "dd");
        Assert.assertTrue(Collection.isCycle(firstList, Arrays.asList("cc", "dd", "aa", "bb")));
        Assert.assertTrue(Collection.isCycle(firstList, Arrays.asList("dd", "aa", "bb", "cc")));
        Assert.assertTrue(Collection.isCycle(firstList, Arrays.asList("bb", "cc", "dd", "aa")));
        Assert.assertFalse(Collection.isCycle(firstList, Arrays.asList("cc", "aa", "dd", "bb")));
        Assert.assertFalse(Collection.isCycle(Arrays.asList("cc", "aa", "dd", "bb", "dd"),
                Arrays.asList("cc", "aa", "dd", "bb")));
    }

    @Test
    public void testReverseOrder() {
        Assert.assertEquals(
                Arrays.asList("dd", "cc", "bb", "aa"),
                Collection.getReverseList(Arrays.asList("aa", "bb", "cc", "dd")));
    }

    @Test
    public void testCombineList() {
        List<String> firstList = Arrays.asList("aa", "bb", "cc", "dd");
        Assert.assertEquals(
                Arrays.asList("aa", "bb", "cc", "dd", "aa", "bb", "cc", "dd"),
                Collection.combineTwoLists(firstList, firstList));
    }


    @Test
    public void testSmallerNumbers() {
        Assert.assertEquals(
                Arrays.asList(1, 2, 3, 4, 5),
                Collection.getSmallerNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 5));
    }
}
