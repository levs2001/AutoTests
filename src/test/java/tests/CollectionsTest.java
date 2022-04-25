package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.bookmarks.BookmarksPage;
import pages.bookmarks.collections.CollectionPage;
import pages.bookmarks.collections.CreateBookmarkCollectionModal;
import utils.MyRandom;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CollectionsTest extends BaseTest {
    @Test
    void createBookmarkCollectionTest() {
        CreateBookmarkCollectionModal createBookmarkCollectionModal =
                new MainPage(webDriver).goToBookmarksPage().openCreateBookmarkCollectionModal();

        String createName = MyRandom.getString();
        BookmarksPage bookmarksPage = createBookmarkCollectionModal.createCollection(createName);
        assertThat("Collection wasn't created.", bookmarksPage.getCollectionNames(), hasItem(createName));

        bookmarksPage.openCollection(createName).edit().openDeleteModal().delete();
        assertThat("Collection wasn't deleted.", bookmarksPage.getCollectionNames(), not(hasItem(createName)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void createManyBookmarksCollectionTest(int collectionC) {
        BookmarksPage bookmarksPage = new MainPage(webDriver).goToBookmarksPage();
        List<String> added = new ArrayList<>();
        for (int i = 0; i < collectionC; i++) {
            CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
            String rndStr = MyRandom.getString();
            bookmarksPage = createBookmarkCollectionModal.createCollection(rndStr);
            added.add(rndStr);
        }
        assertThat("Item wasn't added to collections.", added, everyItem(isIn(bookmarksPage.getCollectionNames())));

        for (String el : added) {
            bookmarksPage.openCollection(el).edit().openDeleteModal().delete();
            bookmarksPage = new BookmarksPage(webDriver);
        }
        assertThat("Item wasn't deleted from collections.", added, everyItem(not(isIn(bookmarksPage.getCollectionNames()))));
    }

    @Test
    void editBookmarkCollectionTest() {
        CreateBookmarkCollectionModal createBookmarkCollectionModal =
                new MainPage(webDriver).goToBookmarksPage().openCreateBookmarkCollectionModal();
        String createName = MyRandom.getString();
        BookmarksPage bookmarksPage = createBookmarkCollectionModal.createCollection(createName);
        assertThat("Collection wasn't created.", bookmarksPage.getCollectionNames(), hasItem(createName));

        CollectionPage collectionPage = bookmarksPage.openCollection(createName);
        assertThat("Incorrect collection name.", collectionPage.getCollectionName(), equalTo(createName));

        String newName = MyRandom.getString();
        collectionPage.edit().openRenameModal().rename(newName);
        assertThat("Renaming failed.", collectionPage.getCollectionName(), equalTo(newName));

        collectionPage.edit().openDeleteModal().delete();
    }

    @Test
    void addBookmarkToCollectionTest() {
        CreateBookmarkCollectionModal createBookmarkCollectionModal =
                new MainPage(webDriver).goToBookmarksPage().openCreateBookmarkCollectionModal();
        String createName = MyRandom.getString();
        BookmarksPage bookmarksPage = createBookmarkCollectionModal.createCollection(createName);

        bookmarksPage.openFirstFeedBookmarkShortcutMenu().addToCollection(createName);
        CollectionPage collectionPage = bookmarksPage.openCollection(createName);

        Assertions.assertFalse(collectionPage.isEmpty());

        collectionPage.edit().openDeleteModal().delete();
    }
}
