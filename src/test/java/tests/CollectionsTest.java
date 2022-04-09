package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        BookmarksPage bookmarksPage = new MainPage(webDriver).goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();

        String createName = MyRandom.getString();
        bookmarksPage = createBookmarkCollectionModal.createCollection(createName);
        assertThat(bookmarksPage.getCollectionNames(), hasItem(createName));

        bookmarksPage.openCollection(createName).edit().openDeleteModal().delete();
        assertThat(bookmarksPage.getCollectionNames(), not(hasItem(createName)));
    }

    @Test
    void createManyBookmarksCollectionTest() {
        BookmarksPage bookmarksPage = new MainPage(webDriver).goToBookmarksPage();
        List<String> added = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
            String rndStr = MyRandom.getString();
            bookmarksPage = createBookmarkCollectionModal.createCollection(rndStr);
            added.add(rndStr);
        }
        assertThat(added, everyItem(isIn(bookmarksPage.getCollectionNames())));

        for (String el : added) {
            bookmarksPage.openCollection(el).edit().openDeleteModal().delete();
            bookmarksPage = new BookmarksPage(webDriver);
        }
        assertThat(added, everyItem(not(isIn(bookmarksPage.getCollectionNames()))));
    }

    @Test
    void editBookmarkCollectionTest() {
        BookmarksPage bookmarksPage = new MainPage(webDriver).goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();

        String createName = MyRandom.getString();
        bookmarksPage = createBookmarkCollectionModal.createCollection(createName);
        String newName = MyRandom.getString();
        CollectionPage collectionPage = bookmarksPage.openCollection(createName).edit().openRenameModal().rename(newName);

        collectionPage.edit().openDeleteModal().delete();
    }

    @Test
    void addBookmarkToCollectionTest() {
        BookmarksPage bookmarksPage = new MainPage(webDriver).goToBookmarksPage();
        CreateBookmarkCollectionModal createBookmarkCollectionModal = bookmarksPage.openCreateBookmarkCollectionModal();
        String createName = MyRandom.getString();
        bookmarksPage = createBookmarkCollectionModal.createCollection(createName);

        bookmarksPage.openFirstFeedBookmarkShortcutMenu().addToCollection(createName);
        CollectionPage collectionPage = bookmarksPage.openCollection(createName);
        Assertions.assertFalse(collectionPage.isEmpty());

        collectionPage.edit().openDeleteModal().delete();
    }
}
