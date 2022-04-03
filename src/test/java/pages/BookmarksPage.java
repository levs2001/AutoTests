package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookmarksPage extends PresentableObject {
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksMenuRB']");
    private static final By CREATE_COLLECTION_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksRB']//*[text() = 'Добавить подборку']");

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

    private By getButtonCollection(String collectionName) {
        return By.xpath("//*[@class = 'bookmarks-navbar-card']//*[text() = '" + collectionName + "']");
    }

    @Override
    protected void check() {
        check(BOOKMARKS_BTN_BY);
    }
}
