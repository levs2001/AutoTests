package tests;

import org.junit.jupiter.api.Test;
import pages.BookmarksPage;
import pages.CollectionPage;
import pages.CreateBookmarkCollectionModal;
import pages.MainPage;

class CollectionsTest extends BaseTest {
    // TODO: Refactor all

    private static final String CREATE_NAME = "Гарри Поттер 2";
    private static final String NEW_NAME = "Гарри Поттер 3";

    @Test
    void createBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);
        bookmarksPage.openCollection(CREATE_NAME).edit().openDeleteModal().delete();
    }

    @Test
    void editCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);
        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);

        CollectionPage collectionPage = bookmarksPage.openCollection(CREATE_NAME).edit().openRenameModal().rename(NEW_NAME);
        // TODO: Fix this test, now is working only in debug mode
        collectionPage.edit().openDeleteModal().delete();
    }

    @Test
    void editBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.goToBookmarksPage().openCollection("Гарри Поттер").edit();//.openCreateBookmarkCollectionModal();
    }
}
