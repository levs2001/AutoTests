package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

class CollectionsTest extends BaseTest {
    @Test
    void testSquareRootOfMinusOneIsNotANumber() {
//        assertThat(Math.sqrt(-1), is(notANumber()));
    }

    @Test
    void testCreateBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.goToBookmarksPage();
    }
}
