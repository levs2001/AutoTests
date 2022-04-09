package pages.bookmarks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.PresentableObject;

public class BookmarkShortcutMenu extends PresentableObject {
    private static final By BOOKMARK_SHORTCUT_MENU_BY = By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[contains(@class, 'bookmarks-shortcut-menu')]");

    public BookmarkShortcutMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToCollection(String collectionName) {
        webDriver.findElement(getCollectionButtonBy(collectionName)).click();
    }

    @Override
    protected void check() {
        check(BOOKMARK_SHORTCUT_MENU_BY);
    }
    
    private static By getCollectionButtonBy(String collectionName) {
        return By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[text() = '" + collectionName + "']");
    }
}
