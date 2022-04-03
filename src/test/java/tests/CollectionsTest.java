package tests;

import org.junit.jupiter.api.Test;
import pages.BookmarksPage;
import pages.CreateBookmarkCollectionModal;
import pages.MainPage;

class CollectionsTest extends BaseTest {
    private static final String CREATE_NAME = "Гарри Поттер 2";

    @Test
    void createBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);
    }

    @Test
    void editBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.goToBookmarksPage().openCollection("Гарри Поттер").edit();//.openCreateBookmarkCollectionModal();
    }
}
