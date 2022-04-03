package tests;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelectionsTest extends BaseTest {
    @Test
    public void testSquareRootOfMinusOneIsNotANumber() {
        assertThat(Math.sqrt(-1), is(notANumber()));
    }
}
