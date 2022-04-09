package pages.bookmarks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pages.PresentableObject;
import pages.bookmarks.collections.CollectionPage;
import pages.bookmarks.collections.CreateBookmarkCollectionModal;

import java.util.ArrayList;
import java.util.List;

public class BookmarksPage extends PresentableObject {
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksMenuRB']");
    private static final By CREATE_COLLECTION_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksRB']//*[text() = 'Добавить подборку']");
    private static final By FIRST_BOOKMARK_FEED_BY = By.xpath("//*[@id = 'hook_Block_AllBookmarksBlock']//*[@class = 'bookmark-big-card']");
    private static final By FIRST_BOOKMARK_FEED_ANCHOR_BY = By.xpath("//*[@id = 'hook_Block_AllBookmarksBlock']//*[contains(@class, 'bookmark-shortcut-menu-anchor__icon')]");
    private static final By BOOKMARK_CARD_TITLE_BY = By.xpath("//*[contains(@class, 'bookmarks-navbar-card_title ellip')]");

    private static final int HOLD_TIME = 300;

    public BookmarksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreateBookmarkCollectionModal openCreateBookmarkCollectionModal() {
        webDriver.findElement(CREATE_COLLECTION_BTN_BY).click();

        return new CreateBookmarkCollectionModal(webDriver);
    }

    public CollectionPage openCollection(String collectionName) {
        webDriver.findElement(getButtonCollection(collectionName)).click();
        return new CollectionPage(webDriver);
    }

    public BookmarkShortcutMenu openFirstFeedBookmarkShortcutMenu() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(FIRST_BOOKMARK_FEED_BY))
                .moveToElement(webDriver.findElement(FIRST_BOOKMARK_FEED_ANCHOR_BY))
                .pause(HOLD_TIME)
                .perform();

        return new BookmarkShortcutMenu(webDriver);
    }

    public List<String> getCollectionNames() {
        List<String> names = new ArrayList<>();
        var els = webDriver.findElements(BOOKMARK_CARD_TITLE_BY);
        for (var el : els) {
            names.add(el.getText());
        }
        return names;
    }

    private By getButtonCollection(String collectionName) {
        return By.xpath("//*[@class = 'bookmarks-navbar-card']//*[text() = '" + collectionName + "']");
    }

    @Override
    protected void check() {
        check(BOOKMARKS_BTN_BY);
    }
}
