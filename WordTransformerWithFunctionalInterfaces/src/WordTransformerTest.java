import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class WordTransformerTest {

    @Test
    public void testWordTransform() {

        Assert.assertEquals("ABC defG IKL", WordTransformer
                .wordTransform("abc defG ikl"));
    }
}