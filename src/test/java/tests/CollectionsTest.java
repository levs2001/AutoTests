package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.MainPage;
import pages.bookmarks.BookmarksPage;
import pages.bookmarks.collections.CollectionPage;
import pages.bookmarks.collections.CreateBookmarkCollectionModal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

class CollectionsTest extends BaseTest {
    // TODO: Add matchers to assert

    private static final String CREATE_NAME = "Гарри Поттер 2";
    private static final String NEW_NAME = "Гарри Поттер 3";

    @Test
    void createBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();

        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);
        assertThat(bookmarksPage.getCollectionNames(), hasItem(CREATE_NAME));

        bookmarksPage.openCollection(CREATE_NAME).edit().openDeleteModal().delete();
        assertThat(bookmarksPage.getCollectionNames(), not(hasItem(CREATE_NAME)));
    }

    @Test
    void editBookmarkCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);
        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        assertThat(bookmarksPage.getCollectionNames(), not(hasItem(CREATE_NAME)));

        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);
        assertThat(bookmarksPage.getCollectionNames(), hasItem(CREATE_NAME));

        CollectionPage collectionPage = bookmarksPage.openCollection(CREATE_NAME);
        assertThat(collectionPage.getCollectionName(), equalTo(CREATE_NAME));

        collectionPage.edit().openRenameModal().rename(NEW_NAME);
        assertThat(collectionPage.getCollectionName(), equalTo(NEW_NAME));

        collectionPage.edit().openDeleteModal().delete();
    }

    @Test
    void addBookmarkToCollectionTest() {
        MainPage mainPage = new MainPage(webDriver);

        BookmarksPage bookmarksPage = mainPage.goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        bookmarksPage = createBookmarkCollectionModal.createCollection(CREATE_NAME);

        bookmarksPage.openFirstFeedBookmarkShortcutMenu().addToCollection(CREATE_NAME);
        CollectionPage collectionPage = bookmarksPage.openCollection(CREATE_NAME);
        Assertions.assertFalse(collectionPage.isEmpty());

        collectionPage.edit().openDeleteModal().delete();
    }
}
