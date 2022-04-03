package tests;

import org.junit.jupiter.api.Test;
import pages.BookmarksPage;
import pages.CollectionPage;
import pages.CreateBookmarkCollectionModal;
import pages.MainPage;

class CollectionsTest extends BaseTest {
    private static final String CREATE_NAME = "Гарри Поттер 2";

    @Test
    void createBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        createBookmarkCollectionModal.createCollection(CREATE_NAME);

        CollectionPage collectionPage = mainPage.goToBookmarksPage().openCollection(CREATE_NAME);

        bookmarksPage.addBookmarkToCollection(CREATE_NAME);
    }

    @Test
    void editBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.goToBookmarksPage().openCollection("Гарри Поттер").edit();//.openCreateBookmarkCollectionModal();
    }
}
