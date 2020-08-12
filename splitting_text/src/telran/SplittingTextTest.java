package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplittingTextTest {
    SplittingText splittingText = new SplittingText();

    @Test
    public void testSplitText_emptyStringAndNewSizeZero() {
        assertEquals("", splittingText.splitText("", 0));
    }

    @Test
    public void testSplitText_emptyStringAndNewSize1() {
        assertEquals("", splittingText.splitText("", 1));
    }

    @Test
    public void testSplitText_newSizeZero() {
        assertEquals("", splittingText.splitText("A", 0));
    }

    @Test
    public void testSplitText_textSize1andNewSize1() {
        assertEquals("A", splittingText.splitText("A", 1));
    }

    @Test
    public void testSplitText_textSize11andNewSize4_emptyString() {
        assertEquals("", splittingText.splitText("Hello world", 4));
    }

    @Test
    public void testSplitText_textSize11andNewSize5_Hello() {
        assertEquals("Hello", splittingText.splitText("Hello world", 5));
    }

    @Test
    public void testSplitText_textSize11andNewSize6_Hello() {
        assertEquals("Hello", splittingText.splitText("Hello world", 6));
    }

    @Test
    public void testSplitText_textSize11andNewSize8_Hello() {
        assertEquals("Hello", splittingText.splitText("Hello world", 8));
    }

    @Test
    public void testSplitText_textSize11andNewSize10_Hello() {
        assertEquals("Hello", splittingText.splitText("Hello world", 10));
    }

    @Test
    public void testSplitText_textSize11andNewSize11_HelloWorld() {
        assertEquals("Hello world", splittingText.splitText("Hello world", 11));
    }

    @Test
    public void testSplitText_textSize25andNewSize30_HelloMyDearFriend() {
        assertEquals("Hello my dear friend", splittingText.splitText("Hello my dear friend", 30));
    }

    @Test
    public void testSplitText_textSize20andNewSize19_HelloMyDear() {
        assertEquals("Hello my dear", splittingText.splitText("Hello my dear friend", 19));
    }

    @Test
    public void testSplitText_textSize20andNewSize20_HelloMyDearFriend() {
        assertEquals("Hello my dear friend", splittingText.splitText("Hello my dear friend", 20));
    }
}